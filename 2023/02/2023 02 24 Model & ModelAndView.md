## Model & ModelAndView Class

### sample01/TestController07
> Model 사용

```java
package my.spring.springweb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testController07")
public class TestController07 {
	private static final Logger logger = LoggerFactory.getLogger(TestController07.class);
	
	@GetMapping
	public String MyMethod(Model model) {
		// Model 안에 담아 렌더링 해 출력
		// ApplicationContext에 의해 Model 객체가 주입됨
		
		logger.debug("testController07이 호출됨");
		
		// 모델 객체에 데이터를 실어줄 건데,
		// 모델은 Map으로 돼 있음
		// key: value 형태로 데이터를 저장
		
		// setAttribute 아님
		model.addAttribute("myName", "백승전");
		model.addAttribute("myAge", 25);
		
		// testController07.jsp로 이동
		return "sample01/testController07";
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
	<h1>testController07 호출</h1>

	
	<!-- 모델 안에 저장돼 있는 데이터를 들고와 여기서 출력해야 됨 -->
	<!-- 출력을 하기 위해 기존 JSP의 표현식과 비슷한 EL을 사용할 것 -->

	<!--	EL의 데이터 표기 방식 ${ } -->
  <!-- 참고로 html이 아닌 JSP의 주석을 따라간다 -->
  <!-- JSP 파일에서, HTML 주석 안에 ${ }만 작성하면 실제로 오류 출력됨 -->

	<!-- model은 request scope 안에 있는 객체 -->
	<ul>
	 	<li>이름: ${myName}</li> <!-- 백승전 -->
	 	<li>나이: ${myAge}</li> <!-- 25 -->
	</ul>
</body>
</html>
```

#### 결과

<img width="495" alt="image" src="https://user-images.githubusercontent.com/85447054/221358034-96f72480-35c9-450e-a74d-9eba60bec898.png">

### sample02/CalcController
> ModelAndView 사용
