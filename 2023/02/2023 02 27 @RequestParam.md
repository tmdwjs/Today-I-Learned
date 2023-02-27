## @RequestParam

평소 request를 보낼 땐 클라이언트에서 서버로 리퀘스트가 가요 라고 표현을 했지만, 사실 3가지 큰 덩어리로 날라갑니다.

client -> server
1. protocol, method, url
2. Header
3. requestBody

get으로 보내게 되면 requestBody에 데이터가 안 들어감 
get 왜 씀? 간단하고 빠르고 쉬우니까
post를 선호하긴 함 

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원정보를 입력하세요 </h1>
	<form action="/springweb/member1" method="post">
		<input type="text" placeholder="이름을 입력하세요" name="name"> <br>
		<input type="text" placeholder="아이디를 입력하세요" name="id"> <br>
		<input type="password" placeholder="비밀번호를 입력하세요" name="password"> <br>
		<input type="number" placeholder="번호를 입력하세요" name="phone">
		<br><br>
		<input type="submit" value="서버로 전송">
	</form>
</body>
</html>
```

```java
package my.spring.springweb.sample02;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springweb.sample02.vo.Member;

@Controller
public class MemberController {
//	private static final Logger  logger = LoggerFactory.getLogger(MemberController.class);

	@PostMapping(value = "member1")
	public ModelAndView myMethod1(@RequestParam(value = "name", defaultValue = "없음") String name, String id,
			@RequestParam(value = "password", defaultValue = "없음") String password,
			@RequestParam(value = "phone", defaultValue = "없음") String phone) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("id", id);
		mav.addObject("password", password);
		mav.addObject("phone", phone);
		// modelandview 객체 만들어 데이터를 붙여주면 request에 담김

		mav.setViewName("sample02/memberView"); // 나중에 내가 사용할 jsp 이름을 담음

		return mav;
	}
}
```

```jsp
```

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원정보를 입력하세요 </h1>
	<form action="/springweb/member2" method="post">
		<input type="text" placeholder="이름을 입력하세요" name="name"> <br>
		<input type="text" placeholder="아이디를 입력하세요" name="id"> <br>
		<input type="password" placeholder="비밀번호를 입력하세요" name="password"> <br>
		<input type="number" placeholder="번호를 입력하세요" name="phone">
		<br><br>
		<input type="submit" value="서버로 전송">
	</form>
</body>
</html>
```

```java
package my.spring.springweb.sample02;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springweb.sample02.vo.Member;

@Controller
public class MemberController {
//	private static final Logger  logger = LoggerFactory.getLogger(MemberController.class);
	@PostMapping(value = "member2")
	public ModelAndView myMethod2(Member vo) {

//		logger.debug(vo.toString());

		ModelAndView mav = new ModelAndView();
		mav.addObject("memberVO", vo);
		mav.setViewName("sample02/memberView");
		return mav;
	}
}

```

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원정보를 입력하세요 </h1>
	<form action="/springweb/member3" method="post">
		<input type="text" placeholder="이름을 입력하세요" name="name"> <br>
		<input type="text" placeholder="아이디를 입력하세요" name="id"> <br>
		<input type="password" placeholder="비밀번호를 입력하세요" name="password"> <br>
		<input type="number" placeholder="번호를 입력하세요" name="phone">
		<br><br>
		<input type="submit" value="서버로 전송">
	</form>
</html>
```
```java
package my.spring.springweb.sample02;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springweb.sample02.vo.Member;

@Controller
public class MemberController {
	@PostMapping(value = "member3")
	// @ModelAttribute(vaule = "")로 저장 시 이름도 지정 가능
	// default로 vo 이름을 소문자로 감 ex) Member -> member
	public ModelAndView myMethod3(@ModelAttribute(value = "mem") Member vo) {

//		logger.debug(vo.toString());

		ModelAndView mav = new ModelAndView();
		mav.addObject("memberVO", vo);
		mav.setViewName("sample02/memberView");
		return mav;
	}
}

```

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원정보를 입력하세요 </h1>
	<!-- 이처럼 들어오는 값이 다르면 어떡할까?  -->
	<form action="/springweb/member4" method="post">
		<input type="text" placeholder="이름을 입력하세요" name="name"> <br>
		<input type="text" placeholder="아이디를 입력하세요" name="id"> <br>
		<input type="password" placeholder="비밀번호를 입력하세요" name="password"> <br>
		<input type="number" placeholder="번호를 입력하세요" name="phone">
		<input type="text" placeholder="주소를 입력하세요" name="addr">
		<br><br>
		<input type="submit" value="서버로 전송">
	</form>
</body>
</html>
```