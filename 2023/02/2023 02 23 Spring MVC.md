## Spring Project 생성
> Package Explorer - New - Spring Legacy Project - Spring MVC

### Package 생성
생성 시 통상적으로 패키지명은 com.~으로 시작하는 생성이 되는데, 현재 연습용 프로젝트에서는 my.spring.springweb으로 생성하도록 합니다.

### Tomcat 연동
> Servers - New - New server - tomcat 9.0

## Spring Project 설정

### Web.xml
> Servlet에 대한 설정을 담당
>> project/src/main/webapp/WEB-INF/web.xml

```xml
<!-- web.xml  -->

<web-app>
  ...
  <!-- 필터 지정 -->
  <!-- 클라이언트에서 들어오는 인코딩 역할을 하는 필터 -->
  <filter>
    <!-- 필터 이름 지정 -->
    <filter-name>encoding filter</filter-name>

    <!-- 필터를 만들면서, 이 패키지 안에 있는 클래스를 지정 -->
    <!-- 스프링이 제공해줌 -->
    <filter-class>
      org.springframework.web.filter.CharacterEncodingFilter
    </filter-class>

    <init-param>
      <param-name>encoding</param-name> <!-- 인코딩 방식을 -->
      <param-value>UTF-8</param-value> <!-- UTF-8로 하겠다는 뜻 -->
    </init-param>
  </filter>

  <!-- 필터 매핑 역할 -->
  <filter-mapping>
    <filter-name>encoding filter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
  ...
</web-app>
```

### HomeController.java

```java
// HomeController.java

package my.spring.springweb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	// RequestMapping이란 Annotation
	// 해당 경로와 GET 방식으로 타고 들어오면 JSP 호출해주는 역할
	// http:localhost:8080/springweb/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		// 해당 경로로 들어와서 home.jsp 호출할게요.
		return "home";
	}	
}
```

### servlet-context.xml
> <code>project/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml</code>

해당 파일은 <code>Spring Container</code> 두 개 중 웹을 담당하는 <code>Servlet Web Application</code>입니다. 어제부터 계속 하던 ApplicationContext( = Bean Factory = IoC Container = Spring Container)을 의미하며 같은 역할을 합니다.

해당 xml 안에는 <code>context:component-scan</code> 태그가 존재합니다. 알다시피 xml이 아닌 annotation으로 bean을 등록할 때 사용합니다.

```xml
<context:component-scan base-package="my.spring.springweb" />
```

먼저, <code>servlet-context.xml</code>의 설정을 알아보기 전에 <code>@Component</code>의 하위 <code>annotation</code>에 대해 알아보도록 하겠습니다.
- @Controller
- @Service
- @Repository
- @Configuration
  - 수동으로 등록해주는 애

상위 네 개는 조금 더 역할에 집중 된 <code>annotation</code>들입니다. 아까 말했다시피 <code>Spring Container</code> 두 개가 각각 담당하는 파일이 있는데요. 하나는 방금 말한 <code>servlet-context.xml</code>이고, 나머지 하나는 <code>root-context.xml</code>입니다. 그리고 이 둘은 각각 아래의 역할을 수행합니다.

- Servlet Web ApplicationContext
	- Controller를 관리
- Root Web ApplicationContext
	- Service와 Repository를 관리

따라서 해당 수업에서는 Servlet Web ApplicationContext이 전부를 관리하고 있기 때문에, Controller만 관리하게 하기 위해 속성을 추가해 이를 분리하는 방법을 알아보도록 하겠습니다.

```xml
<!-- servlet-context.xml -->

<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/mvc"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:beans="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd
		http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

	<!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
	
	<!-- Enables the Spring MVC @Controller programming model -->
	<annotation-driven />

	<!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
	<resources mapping="/resources/**" location="/resources/" />

	<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	
	<!-- 이 친구가 있으면 xml가 아닌 annotation 설정을 가능하게 해 주는 코드 -->
	<!-- use-default-filters의 역할 -->
	<!-- 컴포넌트 찾을 때 '~~ 찾으세요'라는 속성 값이고, true가 디폴트 값이다. -->
	<!-- 근데 해당 수업에서는 사용하지 않을 것이기 때문에, 값을 false로 바꿀 것  -->
	<context:component-scan
	base-package="my.spring.springweb" use-default-filters="false">
	<context:include-filter type="annotation"
		expression="org.springframework.stereotype.Controller" />
	<!-- 쉽게 얘기하면 컨트롤러만 찾으라는 의미 -->
</context:component-scan>
</beans:beans>

```

### root-context.xml

```xml
<!-- root-context.xml -->

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- Root Context: defines shared resources visible to all other web components -->
	<context:component-scan
		base-package="my.spring.springweb" use-default-filters="true">
		<!-- servelt-context.xml과 다르게 use-default-filters의 값을 true로 바꾸고(false에서 제외된 나머지) -->
		
		<!-- include에서 exclude로 설정값을 변경해줘야 함 -->
		<!-- 쉽게 말해, controller는 빼라는 의미 -->
		<context:exclude-filter type="annotation"
			expression="org.springframework.stereotype.Controller" />
	</context:component-scan>
</beans>

```

이렇게 Dependency 설정 후 <code>Update project</code>를 해 설정을 저장합니다.

## Spring Project 구조 및 역할

### Front Controller Pattern

서블릿을 등록할 때 중복된 코드가 계속 들어가는 경우가 있습니다. 이렇게 중복된 코드가 계속 반복되면 유지보수도 힘들고 올바른 코드 작성 관점이랑도 거리가 멀어지게 됩니다. 따라서 중복되는 코드를 모아 하나의 서블릿으로 만들어 사용하는데, 이런 서블릿을 <code>Front Servlet</code>이라 하며 이러한 패턴을 <code>Front Controller Pattern</code>이라고 합니다.

이와 같은 기능이 스프링에서도 제공이 되는데요. 그게 바로 
dispatcher servlet(공통 처리)를 만들 때 가장 큰 장점은 controller를 만들 때 서블릿이 아닌 일반 자바 클래스로 만들어도 됨 예전엔 전부 서블릿으로 만들어야 했지만, 스프링에 들어오면서 그럴 일이 사라짐 이것이 

스프링이 제공해주는 
걔를 이용해서 모든 클ㄹ라이언트 요청을 받을 거고
실제 내가 컨트롤러라 하는 건 일반 클래스
src/main/java/my.spring.springweb
안에 HomeController.java 있음

클래스 위에 @Component가 있으면 bean으로 등록한단 건데,
@Component가 @Controller의 상위이기 때문에,
클래스에 @Controller라 명시하면 얘는 bean으로 등록됨
#### HomeController.java
> my.spring.springweb/HomeController.java
DispatcherServlet으로부터 전달된 request를 처리하는 Controller(Handler)

서블릿이 가지고 있는 특정 서블릿이 기동이 됨

#### webapp
> src/main/webapp
Web의 Home

#### resources
> src/main/webapp/resources
정적 Resource(HTML, CSS, JS, images 등)

#### WEB-INF
> src/main/webapp/WEB-INF
여기에는 client가 직접적으로 접근할 수 없음

#### servlet-context.xml
> src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
Servlet Web ApplicationContext 설정 파일
Spring IoC Container 설정 파일

#### root-context.xml
> src/main/webapp/WEB-INF/spring/root-context.xml
Root Web Application 설정 파일
Spring IoC Container 설정 파일

#### views
> src/main/webapp/WEB-INF/views


jsp는 어디 만들까?
views 안에 
home.jsp = views

#### web.xml
> src/main/webapp/WEB-INF/web.xml
DispatcherServlet mapping 설정

제일 앞단 서블릿 설정이 해당 파일에 위치함

#### pom.xml
프로젝트 전체 설정

servlet-context.xml 안에 viewresolver라는 놈이 있음
얘는 핸들러로부터 만약 스트링이 리턴된다면, 

클라이언트에 리퀘스트가 있으면 디스패처 서블릿이 받는데, 얘가 우리가 만든 @컨트롤러로 넘기는 것 

그래서 핸들러로부터 스트링이 리턴되면 dispatcherServlet이 viewresolver라는 애한테 스트링을 보내서 경로를 만들어 리턴시키는 것 그래야 jsp를 찾을 수 있음

그래서 view 객체 만들고 클라이언트로 

```xml
<!-- servlet-context.xml -->

<beans:bean
  class="org.springframework.web.servlet.view.InternalResourceViewResolver">
  <beans:property name="prefix" value="/WEB-INF/views/" />
  <beans:property name="suffix" value=".jsp" />
</beans:bean>
```

모든 리소스는 dispatcherServlet이 받음 

http://localhost:8080/springweb/
http://localhost:8080/springweb/resources/test.html

### default-servlet-handler 설정

DispatcherServlet(FrontContainer)로부터 request가 들어오면, url 처리를 담당할 핸들러가 있나요? 하고 물어보는 것
디스패쳐서블릿이 있다고 응답 시, 우리가 만든 컨트롤러로 보냄 없을 시 default 서블릿이라는 게 하나 붙어서 그 친구가 동작함 찾으려던 게 없으면 얘한테 넘어가는 거
그리고 해당 url에 대한 처리가 가능하면 정적 resource 처리, 없으면 404 에러

어쨌든, default-servlet-handler를 설정하면
url 처리 핸들러 있나요? 보냄
없나요? 디폴트 서블릿으로 보냄
해당 url 처리 가능한가요? 정적 리소스
못하나요? 404 에러

### Model
model이란 클래스가 있음
모델에 실어서 보내는데, 모델을 직접 보내는 게 아니라 모델에 실으면 jsp가 땡겨서 보냄 개념적으로 

### 프론트 컨트롤러 패턴



### Spring Web MVC


### Handler Mapping

Hadler Mapping Interface가 4개 정도 됨

이중에 한 개만 기억하면 됨 -> RequestMappingHandlerMapping
@RequestMapping annotation 사용할 거
-> class가 아닌 method를 handler로 지정


### Handler Adapter
HandlerAdapter Interface
RequestMappingHandlerAdapter Class 사용

### View

View 객체는 View Interface를 구현한 객체를 지칭함 
모델이 가진 정보를 어떻게 표현해야 하는지에 대한 로직을 가지고 있는 컴포넌트임

View Interface를 구현한 클래스가 스프링에 의해 여러 개 제공 되고 있음
가장 대표적인 게 InternalResourceView
얘 어떻게 만듦?
```java
// 이 jsp 파일로 view 객체를 만드는 것
View view = new InternalResourceView("hello.jsp");
return new ModelAndView(view, model);

// 해당 과정을 통해 DispatcherServlet이 View 객체를 얻을 수 있음
```

만약 뷰 객체를 보내기 싫으면 그냥 문자열만 보내면, 디스패쳐서블릿이 뷰리져브에게 뷰 객체를 만들게끔 리턴함






서블릿에서 response.sendRedirect()처럼
컨트롤러에서 new ModelAndView("", "")를 만드는데,
저 인자값으로 new RedirectView("경로")로 객체를 생성해 모델 뷰로 만들어 사용도 가능함

MarshallingView -> XML
MappingJacksonJsonView Class -> JSON



### logger

```java
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
}
```