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

<img width="608" alt="스크린샷 2023-02-23 오후 6 18 20" src="https://user-images.githubusercontent.com/85447054/220868423-b744399f-0169-4182-affb-cddc60104964.png">

<img width="785" alt="스크린샷 2023-02-23 오후 6 18 45" src="https://user-images.githubusercontent.com/85447054/220868452-03ceac44-6db0-4e21-bd52-1ed931d30f4c.png">


이와 같은 기능이 스프링에서도 제공이 되는데요. 그게 바로 <code>DispatcherServlet</code>입니다.

### DispatcherServlet

<code>DispatcherServlet</code>를 만들 때 가장 큰 장점은, 이전 게시판 프로젝트에서는 모든 컨트롤러를 서블릿으로 만들었는데, 이제는 컨트롤러를 만들 때 서블릿이 아닌 일반 자바 클래스로 만들어도 된다는 것입니다. 예전엔 전부 서블릿으로 만들어야 했지만, 스프링에 들어오면서 최초로 DispatcherServlet을 먼저 거치기 때문에 컨트롤러를 전부 서블릿으로 생성할 필요가 없기 때문입니다.

### HomeController.java
> my.spring.springweb/HomeController.java
<code>DispatcherServlet</code>로부터 전달된 request를 처리하는 컨트롤러(핸들러)입니다.

### webapp
> src/main/webapp

Web의 홈입니다.

### resources
> src/main/webapp/resources

정적 Resource(HTML, CSS, JS, images 등)가 존재합니다.

### WEB-INF
> src/main/webapp/WEB-INF

여기에는 클라이언트가 직접적으로 접근할 수 없습니다. 이전 게시판 프로젝트에서 페이지 이동 시 사용했던 방법처럼 jsp 파일에서 jsp로 요청하는 게 아닌 jsp -> jsp의 역할을 하는 컨트롤러를 거쳐 이동해야 합니다.

### servlet-context.xml
> src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml

Servlet Web ApplicationContext 설정 파일입니다.

### root-context.xml
> src/main/webapp/WEB-INF/spring/root-context.xml

Root Web Application 설정 파일입니다.

### views
> src/main/webapp/WEB-INF/views

앞으로 해당 폴더 안에다 <code>jsp</code> 파일을 만들도록 합니다.

### web.xml
> src/main/webapp/WEB-INF/web.xml

<code>DispatcherServlet</code> 매핑 설정을 하는 파일입니다.

### pom.xml

프로젝트 전체 설정 파일입니다.

## Spring Web MVC 및 주요 개념들

### viewresolver
<code>servlet-context.xml</code> 안에 <code>viewresolver</code>라는 친구가 있습니다. 얘의 역할을 알기 전 우선 메커니즘을 알아야 합니다. 

클라이언트에 요청이 오면 이 request를 <code>DispatcherServlet</code>이 받습니다. 얘가 우리가 만든 컨트롤러로 넘기는 역할을 하는데요. 이후 핸들러로부터 문자열을 리턴 받는다면 <code>DispatcherServlet</code>이 <code>viewresolver</code>라는 애한테 문자열을 보낸 후 만들어진 경로를 받아 jsp의 위치를 찾습니다.

```xml
<!-- servlet-context.xml -->

<beans:bean
  class="org.springframework.web.servlet.view.InternalResourceViewResolver">
  <beans:property name="prefix" value="/WEB-INF/views/" /> <!-- prefix는 앞에 -->
  <beans:property name="suffix" value=".jsp" /> <!-- suffix는 뒤에 붙음 -->
	<!-- 즉 "해당 경로" + ".jsp"로 리턴 -->
</beans:bean>
```

### default-servlet-handler 설정

<code>DispatcherServlet</code>로부터 "request가 들어오면, url 처리를 담당할 핸들러가 있나요?" 하고 물어본다면, 이 질문에 대한 응답을 하는 역할을 합니다.

정확히, <code>DispatcherServlet</code>이 "url을 처리할 핸들러가 있다"고 응답 시, 우리가 만든 컨트롤러로 보냅니다. 이때 우리가 만든 컨트롤러가 없을 시 디폴트 서블릿이 하나 붙어서서 동작을 하게 됩니다. 즉 찾으려던 게 없으면 얘한테 넘어가는 건데요. 이후 갈 곳 잃은 해당 url에 대한 처리가 가능한지 아닌지에 대해 한 번 더 따진 뒤, 가능하다면 <code>정적 resource</code>로 처리, 없으면 <code>404 ERROR</code>를 리턴합니다.

### Model

<code>model</code>이란 클래스가 있습니다. 이 모델에 실어서 보내는데, 모델을 직접 보내는 게 아니라 모델에 실으면 jsp가 땡겨서 보냅니다.

### Handler Mapping

<code>Hadler Mapping Interface</code>가 4개 정도 됩니다. 이 중 기억할 만한 중요한 개념 한 개가 있습니다. <code>RequestMappingHandlerMapping</code>

### Handler Adapter
<code>HandlerAdapter Interface</code> 중 <code>RequestMappingHandlerAdapter</code> 클래스를 사용합니다.

### View
> 모델이 가진 정보를 어떻게 표현할지에 대한 로직을 갖는 컴포넌트

View 객체는 <code>View Interface</code>를 구현한 객체를 지칭합니다. 모델이 가진 정보를 어떻게 표현해야 하는지에 대한 로직을 가지고 있는 컴포넌트입니다.

<code>View Interface</code>를 구현한 클래스가 스프링에 의해 여러 개 제공 되고 있는데요. 이 중 가장 대표적인 게 <code>InternalResourceView</code>

그럼 이 친구는 어떻게 만들어 사용할까요?

```java
// 이 jsp 파일로 view 객체를 만드는 것
View view = new InternalResourceView("hello.jsp");
return new ModelAndView(view, model);

// 해당 과정을 통해 DispatcherServlet이 View 객체를 얻을 수 있음
```

만약 View 객체를 보내기 싫으면 그냥 문자열만 보낼 수 있습니다. 그렇게 하면, <code>DispatcherServlet</code>이 <code>viewresolve</code>에게 뷰 객체를 만들게끔 리턴합니다.

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
