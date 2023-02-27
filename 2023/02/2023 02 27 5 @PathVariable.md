## @PathVariable
> 클라이언트로부터 값을 가져오는 어노테이션 중 하나
>> 주로 REST API를 구현할 때 사용한다

<code>Query String</code>(url?key=value&key=value&..)과는 다릅니다. URL 자체에 클라이언트로부터 들어온 값이 들어있습니다.

### sample04/실습

#### 이미지
> src/main/webapp/resources/images에 이미지들을 담는다

#### 코드
```java
package my.spring.springweb.sample04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {
  // url의 형태
  // name과 num에 다음이 담길 것
	@RequestMapping(value = "/character/detail/{name}/{num}")
	public String myMethod
  (@PathVariable("name") String name,
  @PathVariable("num") int num,
  Model model
  ) {

    // name이 kakao라면,
		if (name.equals("kakao")) {
      // num이 1일 때 해당 이미지 출력
			if (num == 1) {
				model.addAttribute("imgName", "ryan");

      // num이 2일 때 해당 이미지 출력
			} else if (num == 2) {
				model.addAttribute("imgName", "apeach");

      // num이 3일 때 해당 이미지 출력
			} else if (num == 3) {
				model.addAttribute("imgName", "neo");
			}
		}

    // name이 line이라면
		if (name.equals("line")) {
      // num이 1일 때 해당 이미지 출력
			if (num == 1) {
				model.addAttribute("imgName", "brown");

      // num이 2일 때 해당 이미지 출력
			} else if (num == 2) {
				model.addAttribute("imgName", "james");

      // num이 3일 때 해당 이미지 출력
			} else if (num == 3) {
				model.addAttribute("imgName", "cony");
			}
		}

		return "sample04/detailView";
	}
}

```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- url에 따라 imgName란 key에 조건문에 해당하는 value들이 담겨 jsp로 넘어온 것이기 때문에,
      해당 경로에 맞는 이미지들이 담겨 이미지가 출력될 것임 -->
	<img src="/springweb/resources/images/${ imgName }.jpg" />
</body>
</html>
```

#### 결과
> /character/detail/kakao/ryan으로 접속 시