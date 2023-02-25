## log4j
> log4j를 사용해 보자

콘솔에 <code>System.out.println()</code>을 이용해 출력하는 건 여러가지 측면에서 좋지 않습니다. 하지만 자바 개발을 입문하면서, 데이터의 흐름을 파악하거나 디버깅을 할 만한 방법이 없기 때문에 어쩔 수 없이 사용했지만 이제는 다음과 같은 이유로 사용을 지양할 필요가 있습니다.

1. 성능 면에서 좋지 않다
2. 관리적인 측면에서도 좋지 않다
  - 최종적으로 전부 찾아 지워야 하는데, 매우 번거로움
3. 결정적으로 운영 시 log 생성이 필수다

스프링에서는 <code>log4j</code>를 쉽게 이용할 수 있습니다. 우리가 사용할 버전은 <code>log4j 1.x.x</code> 버전을 사용할 것이며, 후에 확장 버전으로 <code>log4j 2.x.x</code>을 변경할 것입니다. 스프링 부트에서는 <code>logback</code> 사용이 가능한데, 저희는 현재 스프링 부트를 사용하지 않기 때문에 이는 스킵하도록 하겠습니다.

<code>log4j</code>는 <code>log4j.xml</code>이라는 설정 파일이 있습니다. 이 설정 파일의 위치는 <code>src/main/resources</code> 경로 안에 존재합니다.

### log4j의 xml 태그들
> xml 파일 안에 눈 여겨 봐야 할 중요한 태그 세 가지가 존재한다

#### appender
> log의 출력 위치를 지정

```xml
<!-- log4j.xml -->

<!-- name은 내가 원하는 대로 지정 -->
<appender name="console" class="org.apache.log4j.ConsoleAppender">
  <!-- param 중요 -->
  <param name="Target" value="System.out" />

  <!-- layout의 역할은 log의 출력 형태를 지정 -->
  <!-- 단순 메시지만 출력할 것인지, 날짜와 같이 찍을 것인지, 
  클래스와 같이 찍을 것인지 등의 부가적인 정보, 모양 등을 지정 -->
  <layout class="org.apache.log4j.PatternLayout">
    <param name="ConversionPattern" value="%-5p: %c - %m%n" />
  </layout>
</appender>
```

<code>appender</code>는 종류가 여러 개가 있습니다.

- Console Appender
  - console
- File Appender
  - File
- RollingFile Appender
  - 용량 제한 File
- Daily Rolling Appender
  - 날짜 별로 File

<code>Console Appender</code>와 <code>Daily Rolling Appender</code>를 많이 사용합니다.

#### layout
> layout의 역할은 log의 출력 형태를 지정

- %p
  - 로그 레벨을 같이 출력
- %m
  - 로그 메시지 출력
- %d
  - 로그 발생 시간 출력
    - yyyy-mm-dd HH:mm:ss
- %c
  - 어떤 파일에서 작성했는지 출력

#### logger
> 메시지를 appender에 전달하는 역할 수행
>> log의 출력 레벨에 따라 출력 여부 결정(레벨은 총 6단계)

```xml
<!-- log4j.xml -->
<logger name="org.springframework.core">
  <level value="info" />
</logger>
```

로그 레벨 6단계
- FATAL
  - 가장 높은 단계
  - 시스템의 심각한 문제가 있음을 의미
- ERROR
  - 실행 중 ERROR가 발생
- WARN
  - 오류의 원인이 될 수 있는 메시지 출력
- INFO
  - application 운영 -> 운영 레벨
    - info() 메서드 존재 
- DEBUG
  - 개발 시 디버깅 용도
    - sysout 대신 사용함
    - debug() 메서드 존재
- TRACE
  - DEBUG의 상세 버전 

<code>log4j.xml</code> 안 <code>logger</code> 태그에서 <code>logger level</code>을 지정 시, 지정한 <code>logger level</code>보다 하위 레벨은 찍히지 않습니다. 따라서 개발 시 레벨을 <code>DEBUG</code>로 지정해 버그를 추적하고, 운영 시 레벨을 <code>INFO</code>로 변경하면, 개발 시 찍어놨던 로그가 출력이 되지 않으며 이를 일일이 지워야 하는 수고도 덜 수 있습니다.

```xml
<logger name="my.spring.springweb">
  <level value="info" />
  <!-- 이런 경우, 로그 레벨이 info보다 하위 레벨은 출력되지 않음 -->
  <!-- 예를 들어, logger.debug() 사용해도 안 나옴 -->
  <!-- 즉, level을 하위 레벨로 잡아 디버그 메시지를 출력하다,
  운영 시 로그의 레벨을 상위 레벨로 지정해주면 출력되지 않음 -->
</logger>
```

---

## Controller, RequestMapping
> @Controller: 특정 클래스가 컨트롤러 역할을 하는 Bean임을 나타내는 어노테이션
> @RequestMapping: 특정 URL로 Request를 보내면 Controller에서 어떠한 방식으로 처리할지 정의

```java
@RequestMapping(value="url path")
```

### sample01/TestController01
> @Controller와 @RequestMapping 학습

```java
package my.spring.springweb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController01 {
	// 로그를 출력할 수 있는 객체가 있어야 함
	// LoggerFactor에서 .getLogger 메서드를 통해 끌어다 씀
	// 인자에는 문자열이 아니라 클래스 입력
	private static final Logger logger = LoggerFactory.getLogger(TestController01.class);
	
	// http://localhost:8080/springweb
	// value 안에 'springweb/' 경로 뒤에 나올 경로를 지정
	// 참고로 경로는 그냥 자유롭게 작성 가능. 지금은 편의를 위해 클래스 명을 따라간 것
	@RequestMapping(value = "/testController01", method=RequestMethod.GET)
	String myMethod() {
		// 개발 할 땐 debug를 사용하는 게 좋음
		// 그래야 추후 운영 시 log4j.xml에서
		// log 레벨을 degub -> info로 변경하면 아무것도 출력 안 되기 때문
		logger.debug("hello world");
		
		// 내가 결과를 보여줄 json을 문자열로 리턴
		return "sample01/testController01";
	}
}
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  </head>
  <body>
    hello world!
  </body>
</html>
```

URL 접속 시 다음과 같이 출력됩니다.

<img src="스크린샷 2023-02-24 오후 1.46.51.png" />

### sample01/TestController02
> 경로 계층 구조로 작성

```java
package my.spring.springweb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 컨트롤러로 만들 것
@Controller
@RequestMapping("/testController02") // requestMapping이 두 개 필요하면 공통된 부분을 계층 구조로 만들 수 있음
// 예를 들면, /testController02/info와, /testController02/profile에서, /testController02를 가장 상위에 작성

public class TestController02 {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController02.class);
	
	@RequestMapping("/info")
	String myMethod0201() {
		logger.debug("hello world ");
		
		return "sample01/testController02";
	}
	
	@RequestMapping("/profile")
	String myMethod0202() {
		logger.debug("hello world");
		
		return "sample01/testController02";
	}
	
	// 이처럼 객체로 매핑도 가능함
	@RequestMapping(value = {"", "/test01", "/test02", "/test03/*"})
	String myMethod0203() {
		logger.debug("hello world");
		
		return "sample01/testController02";
	}
}

```

URL 접속 시 다음과 같이 출력됩니다.

### sample01/TestController05
> GetMapping(params="") 사용

```java
package my.spring.springweb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/testController05")
public class TestController05 {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController05.class);
	
	// param 값 있을 때에만 호출
  // params="myName"라 지정하면,
  // http://localhost:8080/springweb/testController05?myName=백승전
  // 과 같이 get 요청을 보내면 정상 출력 된다
	@GetMapping(params="myName")
	String myMethod0501() {
		logger.debug("testController05 호출");
		return "sample01/testController05";
	}
}
```

URL 접속 시 다음과 같이 출력됩니다.

---

## InternalResourceView Class