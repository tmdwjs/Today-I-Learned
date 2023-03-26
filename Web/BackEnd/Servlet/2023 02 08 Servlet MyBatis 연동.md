# Servlet + MyBatis
> Servlet과 MyBatis를 사용해 로그인 구현하기

## DataTable 생성

```sql
-- schema 생성
-- servletsession

-- schema 선택
USE servletsession;

-- table 생성
CREATE TABLE MEMBERS (
  ID        VARCHAR(10) NOT NULL PRIMARY KEY,
  NAME		  VARCHAR(20) NOT NULL,
  PASSWORD 	VARCHAR(20) NOT NULL
);

-- 데이터 입력
INSERT INTO MEMBERS VALUES('admin', '관리자', '0000');
INSERT INTO MEMBERS VALUES('baik', '백승전', '0000');
INSERT INTO MEMBERS VALUES('son', '손석구', '0000');
INSERT INTO MEMBERS VALUES('yoo', '유아인', '0000');

-- 테이블 조회
SELECT * FROM MEMBERS;  -- |ID    |NAME |PASSWORD |
                        -- |admin |관리자 |0000     |
                        -- |baik  |백승전 |0000     |
                        -- |son   |손석구 |0000     |
                        -- |yoo   |유아인 |0000     |
```

## 환경 세팅
1. 프로젝트 생성
  1. <code>context root</code>는 web의 identifier
2. Maven 프로젝트로 전환
  1. <code>artifactid</code>는 <code>context root</code>와 동일하게 작성함
3. pom.xml에 라이브러리 설정
  1. tomcat 9
  2. mysql 8
  3. mybatis 3

## UI 및 Servlet 생성
```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Sign In</h1>
    <form action="login" method="post">
      <span>ID: </span> <input type="text" name="userID">
      <span>PW: </span> <input type="password" name="userPW">
      <br><br>
      <button type="submit">Login</button>
    </form>
</body>
</html>
```

```java
protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    // 1. 인코딩
    request.setCharacterEncoding("UTF-8");

    // 2. 입력
    String id = request.getParameter("userID");
    String pw = request.getParameter("userPW");

    // 3. 로직
    // 1) VO 생성
    UserVO user = new UserVO();
    user.setId(id);
    user.setPassword(pw);

    // 2) sql table 뽑아내기
    SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession();
    UserVO result = session.selectOne("user.isChecked", user);
    session.close();

    // 4. 출력
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head></head>");
    out.println("<body>");
		
    if (result != null) {
      out.println("Welcome! " + result.getName());
      out.println("<br><br>");
      out.println("<a href='board'> Access bulletin board </a");
    } else {
      out.println("로그인에 실패했습니다.");
    }
		
    out.println("</body></html>");
  }
```

## VO 생성
```java
package vo;

public class UserVO {
  private String id;
  private String name;
  private String password;
	
  public UserVO() {
		
  }
	
  public UserVO(String id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }
  ...
}

```

## Connection Factory 생성
```java
package mybatis;

...

public class ConnectionFactory {
  // SqlSessionFactory 객체 생성
  private static SqlSessionFactory sqlSessionFactory;

  static {
		String resource = "./SqlMapConfig.xml";
    try {
	    Reader reader = Resources.getResourceAsReader(resource);

	    if (sqlSessionFactory == null) {
	      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      }
    } catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    }
	}

  public static SqlSessionFactory getSqlSessionFactory() {
    return sqlSessionFactory;
  }
}

```
## Sql 접속 정보 설정
<code>driver.properties</code>, <code>SqlMapConfig.xml</code>, <code>User.xml</code>