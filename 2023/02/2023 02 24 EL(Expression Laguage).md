## EL 

<code>EL</code>은 Expression Language의 약자로, JSP 표현식과 비슷하며, JSP 2.0 spec 안에 포함돼 있습니다. <code>SP의 JSP Expression</code>J(<%= %>)이나 <code>JJSTL, JSP Scriptlet</code>J(<% %>) 대신 사용합니다.

사용은 다음과 같습니다.

```jsp
<!-- 모델의 key 값이 myName이면, 지금처럼 key값만 가져오면 된다 -->
${myName}
```

<code>pageScope</code> -> <code>requestScope</code> -> <code>seesionScope</code> -> <code>applicationScope</code> 순으로 스코프란 공간을 돌며 모델 객체를 찾아서 값을 찍습니다.

### Scope들의 대표 객체
- pageScope
  - page Context 객체
- requestScope
  - request
  - model
    - 모델 객체가 request scope를 가짐
- sessionScope
  - Session
- applicationScope
  - Servlet Context

<code>EL</code>은 스코프를 명시할 수 있습니다. 만약 찾고자 하는 값이 상위 스코프에 걸려 원하는 값을 가져오지 못할 수 있기 때문에, 스코프를 명시하면 명시한 영역 내에서만 확인하고, 명시하지 않으면 맨 처음에 값이 나올 때까지 모든 스코프를 돌며 찾습니다. 참고로 모델 객체는 <code>requestScope</code> 객체입니다.

### EL의 표현법, 연산, 내장 객체에 대해 알아보자

### 내장 객체
1. pageScope
2. requestScope
3. sessionScope
4. applicationScope
> 1~4번은 해당 스코프를 access 할 때 사용하는 내장 객체

5. param
  - 클라이언트 request parameter의 이름과 값을 가지고 있는 내장 객체
6. header
  - 클라이언트 request header 정보
7. cookie

### sample01/TestController08

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>EL 예제</h1>
  <!-- 입력폼을 한 개 가지고 있으며, 이름과 나이를 입력할 수 있다 -->
	<form action="/springweb/testController08/userEL" method="POST">
		이름: <input type="text" name="userName" /> <!-- 이름 입력폼 -->
		<br><br>
		나이: <input type="number" name="userAge" /> <!-- 나이 입력폼 -->
		<br><br>
		<input type="submit" value="서버로 전송" /> <!-- 클릭 시 서버로 전송 -->
	</form>
</body>
</html>
```

```java
package my.spring.springweb.sample01;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.spring.springweb.sample01.vo.User;

@Controller
@RequestMapping(value = "/testController08")
public class TestController08 {
	private static final Logger logger = LoggerFactory.getLogger(TestController08.class);

	// HTML에서 POST로 넘기기 때문에 어노테이션을 PostMapping으로 잡음
	@PostMapping("userEL") // value 값 넣기
	public String myMethod(Model model) {
		
    // map 형태의 모델 객체
    // 모델에 여러가지 예제를 입력해보고 출력해 볼 예정

    // 1. 객체
		model.addAttribute("myName", "백승전");
		model.addAttribute("myAge", 27);
		
    // 2. 리스트
		List<String> list = new ArrayList<String>();
		list.add("손석구");
		list.add("유아인"); // 예제 6
		model.addAttribute("myList", list); // empty 연산 4
		
    // 3. User VO
		User user = new User("백승전", 200); // 예제 7
		model.addAttribute("myUser", user);
		
		return "sample01/testController08";
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
	<h1>testController08 호출</h1>

  <!-- 백승전, 27 입력 시 -->
	<ul>
		<li>예제 1) 문자 1("" 사용): ${ "test" }</li> <!-- test -->
		<li>예제 2) 문자 2('' 사용): ${ 'test' }</li> <!-- test -->
		<li>예제 3) 숫자: ${ 3.1415 }</li> <!-- 3.1415 -->
		<li>예제 4) 논리(true/false): ${ true }</li> <!-- true -->
		<li>예제 5) null: ${ null }</li> <!-- -->

		<br>

		<li>예제 6) list 출력(myList[1]): ${ myList[1] }</li> <!-- 유아인 -->
		<li>예제 7) Java Bean(VO): ${ myUser.userName }</li> <!-- 백승전 -->
		<li>예제 8) Map(myName): ${ myName }</li> <!-- 백승전 -->

		<br>
			
		<li>예제 9) param 객체(input에 넣은 값): ${ param.userName }</li> <!-- 백승전 -->
		<li>예제 10) header 객체: ${ header.referer }</li> <!-- http://localhost:8080/springweb/resources/sample01/testController08.html -->
		<!-- 뒤로 가기에 사용됨. 내 페이지를 보기 이전의 값이 들어가 있기 때문 -->
		
		<br>
		
		<li>예제 11) 산술 연산(+, =, *, /, %) 가능: ${param.userAge + 2 }</li> <!-- 29 -->
		<li>예제 12) 논리 연산(&&, ||, !) 가능: ${!false }</li> <!-- true -->
		<li>예제 13) 비교 연산(==, !=) 가능: ${param.userAge < 20 }</li> <!-- false -->
		<li>예제 14) 삼항 연산(논리값 ? a : b) 가능: ${param.userAge < 20 ? "미성년자" : "성인"}</li> <!-- 성인 -->

		<br>
		
		<!-- 비었냐 묻는 것 -->
		<li>empty 연산 1) empty "": ${ empty ""}</li> <!-- true -->
		<li>empty 연산 2) empty "abcd": ${ empty "abcd"}</li> <!-- false -->
		<li>empty 연산 3) empty null: ${ empty null}</li> <!-- true -->
		<li>empty 연산 4) empty myList: ${ empty myList}</li> <!-- false -->
	</ul>

	<br>

	<a href="${ header.referer }"> 뒤로 가기 </a>
</body>
</html>
```

이미지