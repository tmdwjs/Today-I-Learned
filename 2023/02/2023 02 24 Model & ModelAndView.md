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
>> 계산기 만들기

```html
<!-- calcForm.html -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>연산할 두 개 숫자를 입력하고 연산자를 선택하세요.</h1>
	<br><br>
	<form action="/springweb/calc.do" method="post">
		<input type="number" name="firstNum" required="required" placeholder="첫 번째 숫자를 입력하세요." /> <!-- required는 값이 없으면 전송 안 됨 -->
		
		<select name="operator">
			<option value="plus"> + </option>
			<option value="min"> - </option>
			<option value="mult"> * </option>
			<option value="div"> / </option>
		</select>
		
		<input type="number" name="secondNum" required="required" placeholder="두 번째 숫자를 입력하세요." />
		
		<br>
		
		<input type="submit" value="계산하기" />
	</form>
</body>
</html>
```

```java
// CalcController.java

package my.spring.springweb.sample02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calc.do")
public class CalcController {
	private static final Logger logger = LoggerFactory.getLogger(CalcController.class);

	@PostMapping
	// 1. ModelAndView 타입 객체 생성
	public ModelAndView process(int firstNum, int secondNum, String operator) {
		// 2. 사용자가 보내준 데이터를 받아야 함
		// @RequestParam("")을 이용해서 받음(String primitive type인 경우)
		// 그렇게 되면 인자를 다음과 같이 들어옴

		// (@RequestParam("firstNum") int firstNum, @RequestParam("secondNum") int secondNum,
		// @RequestParam("operator") String operator, Model model)

		// 하지만 이는 생략이 가능하다
		// 보다시피 @RequestParam("") 안에 이름과, param 값이 같은 것을 확인할 수 있는데,
		// 같게 작성하면, 이런 경우에는 맨 위에 작성한 것처럼 @RequestParam("")을 생략이 가능해 축약해 작성할 수 있다
		// 하지만 저렇게 풀 네임으로 다 써 주는 게 원칙이긴 하다
		
		ModelAndView mav = new ModelAndView();
		String viewName = "";
		
		if(operator.equals("div") && secondNum == 0) {
			// 나눗셈 하는데 당연히 분모가 0이면 안 됨. 무한대 개념이 없어서 Exception 처리 됨
			// 이런 경우 error message를 출력하는 jsp로 보내자
			viewName = "sample02/errorResult"; // 3. 실패 시 error 페이지
			mav.addObject("msg", "0으로 나눌 수 없어요.");
		}else {
			int result = 0;
			
			if(operator.equals("plus")) {
				result = firstNum + secondNum;
			}else if(operator.equals("minu")) {
				result = firstNum - secondNum;
			}else if(operator.equals("mult")) {
				result = firstNum * secondNum;
			}else {
				result = firstNum / secondNum;
			}
			
			viewName = "sample02/calcResult"; // 3. 성공 시 이동할 문자열 jsp 명시해주고
			mav.addObject("msg", result); // 4. ModelAndView에 담기
		}
		
		mav.setViewName(viewName); // 5. ModelAndView 세팅
		return mav;
	}
}

public ModelAndView process(@RequestParam("firstNum") int firstNum, @RequestParam("secondNum") int secondNum,
		@RequestParam("operator") String operator, Model model) {
	// 2. 사용자가 보내준 데이터를 먼저 받아야 함

	return null;
}
```

```jsp
<!-- calcResult -->

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
	<h1>연산 성공.</h1>
	<h3> msg 결과는: ${ requestScope.msg }</h3>
	
 	<a href="${ header.referer }"> 뒤로 가기 </a>
</body>
</html>
```

#### 결과
> 1 + 2
<img width="468" alt="image" src="https://user-images.githubusercontent.com/85447054/221407166-6a16b49d-7283-4639-9b12-afe393ddc2af.png">

> 1 / 0
<img width="486" alt="image" src="https://user-images.githubusercontent.com/85447054/221407180-404fc0be-f3fa-4c76-9d3c-9bbe894e1b59.png">


```jsp
