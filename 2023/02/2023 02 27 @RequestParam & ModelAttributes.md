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