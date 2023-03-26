# Servlet Context
> 여러 Servlet이 공유하는, 저장 공간 역할을 하는 객체이다.

<code>Servlet</code>에서 다른 <code>Thread</code>들이 필드를 공유하기 위해선 <code>Singleton</code> 패턴이 전제가 돼야 합니다. 하지만 실제 운영 시, <code>Singleton</code> 패턴이 아닌 경우가 생기는데요. 이런 경우 공유 객체를 제공 받기 위해 <code>Servlet Context</code>를 사용할 수 있습니다.

만약 클라이언트에서 로그인 후, 첫 번째 <code>FirstServlet</code>에서, 클라이언트를 우회해 두 번째 <code>SecondServlet</code>으로 간다면, <code>SecondServlet</code>에서는 <code>FirstServlet</code>에서 받은 이름을 <code>Servlet Context</code>를 사용해 알 수 있습니다.

```java
// FirstServlet.java
protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8"); // 서버 측에서 받은 한글 인코딩
    String name = request.getParameter("userName"); // html에서 입력을 받음

    // Servlet Context를 가져와서 여기에 이름을 저장
    ServletContext context = this.getServletContext();
    context.setAttribute("memberName", name); // setAttribute란 method 사용(put으로 입력 아님!)
		
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head></head>");
    out.println("<body>");
    // client에게 link 주는 것
    // 클릭 시 secondServlet으로 이동
    out.println("<a href='secondServlet'>Invoke second servlet</a>");
    out.println("</body></html>");
  }
```

```java
// SecondServlet.java
protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    // 다른 servlet에서 context를 이용해 저장된 값을 사용할 것

    // context 가져와서
    ServletContext context = this.getServletContext();
    // 내가 저장한 key 값 'memberName'을 가져온다.
    // 이때 Object 타입으로 나오기 때문에 String으로 cast 해 줘야 함.
    String name = (String) context.getAttribute("memberName"); 

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head></head>");
    out.println("<body>");
    out.println("Name is: " + name); // client에게 link 주는 것
    out.println("</body></html>");
  }
```

# Session

우리가 웹에서 사용하는 HTTP 프로토콜은 동작 방식이 간단하지만, 연결성이 없어 서버 쪽에 클라이언트의 상태(정보)도 남아 있지 않게 됩니다. 가령 로그인 한 유저만 접속이 가능한 페이지를 구현할 때, 로그인에 실패해도 접속 URL만 알고 있어 다이렉트로 접속을 시도하면 문제가 될 수 있습니다. 이때 <code>Session</code>을 사용해 로그인 한 사용자인지 아닌지 판별할 수 있습니다.

<code>Session</code>은 나만 쓸 수 있는 객체입니다. 2번에 <code>request</code>가 나갈 때, 이 안에 <code>session id</code>를 담아서 내보내며, 영구적이진 않지만 사용 후 바로 안 날라가기 때문에 이를 사용해 유효성 검사가 가능해집니다.


## Session을 이용한 Login 구현

```html
<!-- 로그인 페이지 -->
<body>
  <h1>Sign In</h1>
  <form action="login" method="post">
    <span>ID: </span> <input type="text" name="userID">
    <span>PW: </span> <input type="password" name="userPW">
    <br><br>
    <button type="submit">Login</button>
  </form>
</body>
```

```java
// LoginServlet
protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    // 클라이언트로부터 받은 아이디와 비밀번호 저장
    String userID = request.getParameter("userID");
    String userPW = request.getParameter("userPW");

    // VO 생성
    UserVO user = new UserVO();
    user.setId(userID);
    user.setPassword(userPW);

    // sql table 뽑아내기
    SqlSession sqlSession = ConnectionFactory.getSqlSessionFactory().openSession();
    UserVO result = sqlSession.selectOne("user.isChecked", user);
    sqlSession.close(); // 사용했으면 닫기

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head></head>");
    out.println("<body>");
		
    // result가 존재 = 로그인 성공 시
    if (result != null) {
      // 이때 session 객체를 할당 받을 것
      // servlet container에게 session 객체를 요청

      // 여기서 request.getSession(true);의 의미는
      // 내게 기존에 할당된 session 객체가 없으면 만들어 주고,
      // 만약 기존에 내가 할당 받은 session 객체가 있으면 그것을 달라는 의미
      HttpSession session = request.getSession(true);

      // 이 session 객체는 map 형태
      session.setAttribute("loginName", result.getName());
      // 내가 정한 key 값으로 값을 가져다 박을 것. getName = user vo 이름
      // 이렇게 해 놓고 로그인이 필요한 페이지로 넘어가면 됨
    } else {

      // 로그인 실패 시
      out.println("로그인에 실패했습니다.");
    }
		
    out.println("</body></html>");
  }
```
```java
// BoardServlet
protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    // 여기는 로그인 한 사람만 접속할 수 페이지

    // 시작하자마자 session을 가져옴
    // 나에게 기존 할당된 session 객체가 있으면 그거 주고
    // 없으면 만들지 말고 null을 return 하라는 것 -> 이것이 getSession(false);
    HttpSession session = request.getSession(false);

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head></head>");
    out.println("<body>");

    if (session != null) {
      // 성공 시 이름을 가져와 'OOO 님 환영합니다.'와 같은 문구를 띄울 것
      // 따라서, session에서 저장했던 'loginName'을 getAttribute로 가져온다.
      String name = (String) session.getAttribute("loginName");
      out.println("<h1> Welcome " + name + "</h1> ");
    } else {
      out.println("<h1> bye bye </h1>");
    }

    out.println("</body></html>");
  }
```