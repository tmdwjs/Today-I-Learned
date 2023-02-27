## @RequestParam

### 1. 이름, 아이디, 비밀번호, 번호 입력
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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springweb.sample02.vo.Member;

@Controller
public class MemberController {
	@PostMapping(value = "member1")
	public ModelAndView myMethod1(
		@RequestParam(value = "name", defaultValue = "없음") String name,
		String id, // @RequestParam(value="")와 인자가 같으면 생략 가능
		@RequestParam(value = "password", defaultValue = "없음") String password,
		@RequestParam(value = "phone", defaultValue = "없음") String phone
		) {
		ModelAndView mav = new ModelAndView(); // ModelAndView 객체 생성
		// ModelAndView에 key: value로 값 할당
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보</h1>
	<ul>
		<li>이름: ${ name }</li>
		<li>아이디: ${ id }</li>
		<li>비밀번호: ${ password }</li>
		<li>번호: ${ phone }</li>
	</ul>
	
	<br>

	<a href="${ header.referer }"> 뒤로 가기 </a>
</body>
</html>
```

### 2. VO로 넘겨주기
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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springweb.sample02.vo.Member;

@Controller
public class MemberController {
	@PostMapping(value = "member2")
	public ModelAndView myMethod2(Member vo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberVO", vo);
		mav.setViewName("sample02/memberView");
		return mav;
	}
}

```
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보</h1>

	<!-- 배운 내용대로 JSTL의 choose 태그를 사용해 봄 -->
	<!-- VO의 내용이 있으면 VO, 없으면 EL로 다른 내용을 받아올 것 -->
	<c:choose>
		<!-- !empty는 내용이 있다는 의미와 같다 -->
		<c:when test="${ !empty requestScope.memberVO }">
			<ul>
				<li>이름: ${ memberVO.name }</li>
				<li>아이디: ${ memberVO.id }</li>
				<li>비밀번호: ${ memberVO.password }</li>
				<li>번호: ${ memberVO.phone }</li>
			</ul>
		</c:when>

		<c:otherwise>
			<ul>
				<li>이름: ${ name }</li>
				<li>아이디: ${ id }</li>
				<li>비밀번호: ${ password }</li>
				<li>번호: ${ phone }</li>
			</ul>
		</c:otherwise>
	</c:choose>
	
	<br>

	<a href="${ header.referer }"> 뒤로 가기 </a>
</body>
</html>
```

### 3. VO에 이름 설정
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
	public ModelAndView myMethod3(
		@ModelAttribute(value = "mem") Member vo) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("memberVO", vo);
		mav.setViewName("sample02/memberView");
		return mav;
	}
}
```
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보</h1>

	<c:choose>
		<c:when test="${ !empty requestScope.mem }">
			<ul>
				<!-- member vo를 mem으로 지어줬으니, 
						다음처럼 mem으로 데이터를 받아올 수 있다
				-->
				<li>이름: ${ mem.name }</li>
				<li>아이디: ${ mem.id }</li>
				<li>비밀번호: ${ mem.password }</li>
				<li>번호: ${ mem  .phone }</li>
			</ul>
		</c:when>
		
		<c:when test="${ !empty requestScope.memberVO }">
			<ul>
				<li>이름: ${ memberVO.name }</li>
				<li>아이디: ${ memberVO.id }</li>
				<li>비밀번호: ${ memberVO.password }</li>
				<li>번호: ${ memberVO.phone }</li>
			</ul>
		</c:when>

		<c:otherwise>
			<ul>
				<li>이름: ${ name }</li>
				<li>아이디: ${ id }</li>
				<li>비밀번호: ${ password }</li>
				<li>번호: ${ phone }</li>
			</ul>
		</c:otherwise>
	</c:choose>
	
	<br>

	<a href="${ header.referer }"> 뒤로 가기 </a>
</body>
</html>
```

### 4. VO 외 다른 값 입력하기
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
	@PostMapping(value = "member4")
	public ModelAndView myMethod4(Member vo, String addr) {
		// 인자를 두 개 받으면 됨
		...

		return mav;
	}
}
```