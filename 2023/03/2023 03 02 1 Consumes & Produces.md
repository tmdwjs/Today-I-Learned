## consumes
> 클라이언트의 request를 제한하는 용도로 사용

클라이언트 안에 header의 <code>content-type</code>를 참조합니다. 이때 <code>content-type</code>은 얘가 어떤 타입이라고 알려주는 역할을 합니다. 

다시 돌아와 클라이언트에서 요청 시 request에는 <code>start line</code>과 <code>header</code>, <code>body</code> 이 세 가지 라인으로 돼 있습니다.이때 클라이언트 서버에 보내줄 데이터는 바디에 실리는데, GET 요청은 URL 뒤에 Query String을 요청하기 때문에 GET 요청 시 <code>body</code>가 아니라 <code>start line</code>에 실리게 됩니다.

그렇다 보니 <code>body</code> 안에 데이터가 없어 <code>content-type</code>이 명시가 안 되니 GET 방식으로는 reuquest를 보낼 수 없게 됩니다. 결론적으로 <code>content-type</code>이 없는 GET 요청은, consumes를 잡게 되면 request 처리를 할 수가 없게 됩니다.

### GET 요청 

```java
@RequestMapping(value = "/testController1", method = RequestMethod.GET, consumes = { "application/json",
			"application/xml" }

	)
	public String myMethod1() {
		log.debug("GET 방식으로 호출 됨");
		return null;
	}
```

#### 결과

<img src="https://user-images.githubusercontent.com/85447054/222303315-29a229da-4756-4de5-aa00-f17e69fab7dc.png" width="600" />

415 에러가 출력되는 것을 볼 수 있습니다. 왜냐하면 요청 헤더에 <code>content-type</code>이 없기 때문입니다.


<img src="https://user-images.githubusercontent.com/85447054/222303197-8aa1dc3e-36ab-49cc-8cd9-f723764c6529.png" width="600" />
<img src="https://user-images.githubusercontent.com/85447054/222303480-b527f749-cf32-401e-9b23-cb92da5c1685.png" width="600" />

### POST 요청 

#### 결과 

<img src="https://user-images.githubusercontent.com/85447054/222304047-e7c2b984-2f61-4548-8b00-31dce824bef5.png" width="600" />

여전히 에러가 출력되긴 하지만 요청 헤더에 <code>content-type</code>이 확인이 되긴 합니다. 해당 에러는 <code>content-type</code>의 내용을 <code>consumes</code>에 허용을 안 해 줬기 때문인데요. 추가해준 뒤 결과와 로그를 다시 확인해 보면 에러가 415에서 404로 바뀐 것을 확인할 수 있습니다.

#### content-type 일치하도록 명시
```java
@RequestMapping(value = "/testController2", method = RequestMethod.POST, consumes = { "application/json",
			"application/x-www-form-urlencoded" }

	)
	public String myMethod2() {
		log.debug("POST 방식으로 호출 됨");
		return null;
	}
```

<img src="https://user-images.githubusercontent.com/85447054/222304001-73e5d267-0e10-47a4-b4b8-4f9c7b75a5f8.png" width="600" />

<img src="https://user-images.githubusercontent.com/85447054/222303953-e6e12566-226d-4fc0-9e51-e7eaa3bd275b.png" width="600" />

보통 request를 특별한 경우가 아닌 이상 요청을 제한하는 경우가 거의 없습니다. 위 경우보다는 보통 요청을 처리한 다음, 서버에서 클라이언트한테 데이터를 전달할 때 해당 데이터가 일반적인 html인지, json, xml인지 정해줘야 하는 경우가 많은데 그때 사용됩니다.

---

## produces


여기서 지정한다는 의미는 서버가 클라이언트에게 데이터를 리턴할 때, 그 데이터를 해당 타입으로 변환하겠다는 얘기는 아닙니다. 나중에 나오겠지만 <code>produces</code>는 혼자 안 쓰이고 <code>@ResponeseBody</code>라는 어노테이션과 함께 쓰입니다

---

## ApplicationContextAware
> Bean을 수동으로 등록해 보자

produces 나가기 전에 먼저, produces는 리턴하는 데이터의 content-type을 지정하는 역할을 한다고 했습니다. 만약 JSON 타입을 리턴하게 된다면, Gson 라이브러리를 활용해 매번 json을 만들러 리턴해 줘야 합니다.

### Gson Bean 주입: @Autowired 사용

```java
// sample09/common/LibraryComponent.java
// Gson Bean 

package my.spring.springweb.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

// Bean을 Application context로 등록하려면
// @Bean을 사용해야 하는데,
// @Bean은 메서드에만 사용됨 즉,
@Configuration
public class LibraryComponent {
	@Bean
	public Gson getGson() {
		return new Gson();
	}
}

```

```html
<!-- sample09/index.html -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Test </h1>
	<hr>
  <!-- 중간 내용 생략 -->
	<h3> GET 방식으로 호출 4 </h3> <!-- json -->
	<a href="/springweb/testProduces4"> produces의 content-type: Gson으로 출력, 결과는 JSP  </a>
</body>
</html>
```

```java
// sample09/RequestMappingProducesController.java

// import 생략

@Controller
public class RequestMappingProducesController {
	Logger log = LogManager.getLogger("case3");
	
  // 1. Gson Bean 자동으로 주입 
  // @Autowired
  // private Gson gson;

	// 중간 내용 생략 
	
	@RequestMapping(value = "testProduces4", produces = "text/html; charset=UTF-8")
	public String myMethod04(HttpServletResponse response) {
		try {
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
      // 2. VO 생성 
			Map<String, String> map = new HashMap<String, String>();
			map.put("userName", "백승전");
			map.put("userAge", "20");
			map.put("userAddr", "서울");
			
			// 3. 이 데이터를 JSON 문자열로 변환
			// 그리고나서 Stream을 통해 클라이언트에게 보내주면 됨
      // 4. 
      // gson = new Gson();
      // String str = gson.toJson(map);
			
			String str = gson.toJson(map);
			
			out.println(str);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sample08/requestMappingProducesView";
	}
}
```

![](2023-03-02-18-10-01.png)

근데 <code>@Autowired</code> 어노테이션을 사용해 자동이 아닌 수동으로 등록하는 게 나을 때가 있습니다. Bean을 수동으로 등록하면 <code>1</code> 외부 라이브러리(Gson 등)를 빈으로 등록해서 효율적으로 사용이 가능합니다. 그 이유는 <code>2</code> 프로그램이 크기가 커지고 자주 기능이 변경되는 경우에는 편리함을 위해 무작정 자동으로 등록하는 것보다는 수동이 나을 수 있기 때문입니다.

그러면 <code>@Autowired</code>을 남발하기 싫은데, <code>Application Context</code>를 어떻게 직접 사용할까요? 우선 구현체를 만들어야 합니다. 스프링에서는 인터페이스를 제공해줍니다. 바로 <code>ApplicationContextAware</code>인데요. 이를 구현한 구현체를 Bean으로 등록하면 따라서 인터페이스를 기반으로 구현 클래스를 수동으로 등록해 전략 패턴을 이용한다면 프로그램을 쉽게 끌고갈 수 있습니다. 

### Gson Bean 주입: ApplicationContextAware 사용

스프링에서 제공해주는 <code>ApplicationContextAware</code>를 구현 받기 위해 구현체를 생성할 것입니다. 이름은 맘대로 지어도 되지만 일반적으로 'ApplicationContext를 제공'해준다 해서 <code>ApplicationContextProvider</code>라고 짓습니다. 

```java
// sample09/common/ApplicationContextProvider.java

package my.spring.springweb.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware{

	private static ApplicationContext ctx;
	
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
	
	// 1. setter에 값 들어옴 
	// 2. 이를 static으로 잡은 필드에 담음 
	// 참고로 객체 생성 안 하려고 static으로 잡은 것 
	// 3. ctx 리턴
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx = applicationContext;
	}
}
```

```java
// sample09/RequestMappingProducesController.java

// import 생략

@Controller
public class RequestMappingProducesController {
	Logger log = LogManager.getLogger("case3");
	
  // 1. 이제 해당 과정 필요 없음
  // @Autowired
  // private Gson gson;

	// 중간 내용 생략 
	
	@RequestMapping(value = "testProduces4", produces = "text/html; charset=UTF-8")
	public String myMethod04(HttpServletResponse response) {
		try {
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("userName", "백승전");
			map.put("userAge", "20");
			map.put("userAddr", "서울");
			
      ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
			Gson gson = ctx.getBean("getGson", Gson.class);

			String str = gson.toJson(map);
			
			out.println(str);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sample08/requestMappingProducesView";
	}
}
```

![](2023-03-02-18-16-22.png)

---

## produces
> 클라이언트에게 리턴하는 데이터의 content-type을 지정

다시 produces로 돌아와서,

### HTTP의 기본 통신 방식

HTTP의 단순한 구조는 <code>Request</code>와 <code>Response</code>로 이루어져 있습니다. 여기서 더 자세히 보면,

### HttpRequest

#### 1. start line

<code>방식 / URL / HTTP 프로토콜 버전</code>의 형태를 가지고 있습니다. 예를 들면 <code>POST /springweb/.. HTTP/1.1</code>와 같습니다.

#### 2. headers

<code>content-type</code>를 포함한 잡다한 정보가 있습니다.

#### 3. body

<code>body</code>의 경우 request와 response 두 개에 다 존재하는데요. request에 존재하는 body를 <code>request body</code>, response에 존재하는 body를 <code>response body</code>라고 합니다

### HttpResponse

#### 1. Start line
> 상태 코드가 담겨있음

<code>200</code>: success(성공)<br>
<code>201</code>: create(생성됨)<br>
<code>403</code>: forbidden(권한 없음)<br>
<code>404</code>: not found(찾을 수 없음)<br>
<code>415</code>: content-type이 다름<br>
<code>500</code>: 서버 이상.<br>

#### 2. headers

#### 3. body

response body에는 JSON을 넣어야 합니다. 그리고 이제부터 JSP는 안 쓰고 데이터만 넘길 것입니다. 즉, JSON 아니면 XML만 실어 보낼 건데(일반적으로 JSON이 실림) 클라이언트가 보낸 데이터를 JSON으로 보내는 게 저희가 계속 했던 <code>AJAX</code>입니다.

따라서 컨트롤러를 만들 때도 기존 방식이냐 REST 방식이냐를 구분해 컨트롤러를 만들어주면 되는데요. 앞으로의 수업 과정은 후자의 내용을 진행하려고 합니다.

다시 돌아와, body 부분에 직접 데이터를 실어 보낼 것이기 때문에 해당 데이터가 어떤 데이터인지를 명시해야 하고 그 역할을 <code>produces</code>가 하게 됩니다.

### 일반적인 경우(JSP 파일 환경)

#### 1. Request -> Dispatcher servlet

Dispatcher Servlet을 <code>front controller</code>라고도 합니다.

#### 2. Dispatcher Servlet -> Handler Mapping

handler mapping이 request url을 처리할 수 있는 컨트롤러를 찾아다닙니다.

#### 3. Handler Mapping -> Dispatcher Servlet

#### 4. Dispatcher Servlet -> Handler Adapter -> Controller

#### 5. Controller -> Service -> Repository(dao) -> DB

#### 6. DB -> Repository -> Service -> Controller

#### 7. Controller -> Model -> Controller

문자열의 데이터를 넘기고,

#### 8. Controller -> Hander Adapter

View Resolver을 넘깁니다.

#### 9. Hander Adapter -> Dispatcher Servlet -> View Resolver

dispatcher servlet은 view resolver에게 view name을 넘기고

#### 10. view resolver -> view object -> model -> view object

### 다른 경우(REST 기반)
> Controller가 데이터를 직접 client에게 보내는 경우

REST 기반으로 클라이언트의 ajax 호출에 대한 결과를 리턴하는 흐름입니다. JSP를 사용하지 않기 때문에 여러가지 바뀌는 부분이 있습니다.

#### produces 속성

기존과 다르게 produces를 사용해 리턴값을 JSON이라고 명시해 줘야 합니다.

#### @ResponseBody

그리고 responsebody에 추가합니다.

### 흐름도

#### 1. request -> dispatcher servlet

#### 2. dispatcher servlet -> handler mapping

#### 3. handler mapping -> dispatcher servlet

#### 4. dispatcher servlet -> handler adapter -> controller

#### 5. controller -> service -> repository(dao) -> DB

#### 6. DB -> repository -> service -> controller

여기까지는 JSP와 같습니다.

#### 7. controller -> response entity

이때 스프링에서 제공하는 <code>Response Entity</code>라는 객체를 생성합니다. 그리고 이를 <code>Handler Adapter</code>에게 전달합니다. 그러면서 동시에 모델에 저장할 데이터를 <code>Response Entity</code>에 담았으니 Model과 View Resolver 등이 빠지게 됩니다. 여기서 데이터가 핸들러와 상태 코드가 들어갑니다.

#### 8. response entity -> handler adapter -> dispatcher servlet -> response

사실상 스프링을 쓰면 gson을 쓸 필요가 없습니다. 왜냐하면 스프링은 <code>Message Converter</code>라는 애를 가지고 있는데, 이를 사용해 JSON으로 리턴이 가능하기 때문입니다.