## consumes
> 클라이언트의 request를 제한하는 용도로 사용

클라이언트 안에 header 정보(<code>content-type</code>)를 참조합니다.

GET은 URL 뒤에 Query String을 요청함
리퀘스트는 start line과 header, body 이 세 가지 라인으로 돼 있음
클라이언트 서버에 보내줄 건 바디에 실리는데,
GET 방식은 바디가 아니라 startline에 실리게 됨
content type은 얘가 어떤 타입이라고 알려주는 역할을 함
근데 get 방식은 스타트라인에 실리게 되다 보니 바디 안에 데이터가 없어 컨텐트 타입이 명시가 안 돼 있음
겟방식으로는 request 보낼 수가 없게 됨 

확인해 보자 

get 방식은 어차피 contenttype이 없어서 consumes 잡으면 해당 request를 처리할 수 없음

### GET 요청 

#### 결과

<img src="https://user-images.githubusercontent.com/85447054/222303315-29a229da-4756-4de5-aa00-f17e69fab7dc.png" width="600" />

415 에러가 출력되는 것을 볼 수 있습니다. 왜냐하면 요청 헤더에 <code>content-type</code>이 없기 때문입니다.


<img src="https://user-images.githubusercontent.com/85447054/222303197-8aa1dc3e-36ab-49cc-8cd9-f723764c6529.png" width="600" />
<img src="https://user-images.githubusercontent.com/85447054/222303480-b527f749-cf32-401e-9b23-cb92da5c1685.png" width="600" />

### POST 요청 

#### 결과 

<img src="https://user-images.githubusercontent.com/85447054/222304047-e7c2b984-2f61-4548-8b00-31dce824bef5.png" width="600" />

여전히 에러가 출력되긴 하지만 요청 헤더에 <code>content-type</code>이 확인이 되긴 합니다. 해당 에러는 <code>content-type</code>의 내용을 <code>consumes</code>에 허용을 안 해 줬기 때문인데요. 추가해준 뒤 결과와 로그를 다시 확인해 보면 에러가 415에서 404로 바뀐 것을 확인할 수 있습니다.


<img src="https://user-images.githubusercontent.com/85447054/222304001-73e5d267-0e10-47a4-b4b8-4f9c7b75a5f8.png" width="600" />

<img src="https://user-images.githubusercontent.com/85447054/222303953-e6e12566-226d-4fc0-9e51-e7eaa3bd275b.png" width="600" />


보통 request를 특별한 경우가 아닌 이상 요청을 제한하는 경우가 거의 없습니다. 위 경우보다는 보통 요청을 처리한 다음, 서버에서 클라이언트한테 데이터를 전달할 때 해당 데이터가
일반적인 html인지, json, xml인지 정해줘야 하는 경우가 많은데 그때 사용됩니다.

content-type을 정해야 할 필요가 있다는 뜻 

request, response는 헤더 안에 들어있음  

Mime type은 헤더 안에 

---

## produces
> 클라이언트에게 리턴하는 데이터에 content-type을 지정

여기서 지정한다는 의미가 마치 서버가 클라이언트에게 데이터를 리턴할 때 그 데이터를 해당 타입으로 변환하겠다는 얘기는 아닙니다. 나중에 나오겠지만 <code>produces</code>는 혼자 안 쓰이고 <code>@ResponeseBody</code>라는 어노테이션과 함께 쓰입니다


-

Bean을 수동으로 등록하면 
1. 외부 라이브러리(Gson 등)를 빈으로 등록해서 효율적으로 사용이 가능 
2. 프로그램이 크기가 커지고 자주 기능이 변경되는 경우에는 자동 등록보다는 수동이 나을 수 있다 
인터페이스를 기반으로 구현 클래스를 수동으로 등록해서 전략 패턴을 이용하면 프로그램을 쉽게 끌고갈 수 있음

---

produces 나가기 전에 잠깐,

## ApplicationContextAware
> Bean을 수동으로 등록해 보자

@Autowired을 남발하기 싫은데, Application Context를 직접 사용하는 방법이 있나요

할 수 있다 단 구현체를 만들어야 함 
interface를 제공해 줌 
이름하야 ApplicationContextAware
구현한 구현체를 Bean으로 등록해 

이름은 맘대로 지어도 되지만 일반적으로 ApplicationContext를 제공해준다 해서 ApplicationContextProvider라고 지음 
그리고 ApplicationContextAware를 구현 

---

다시 produces로 돌아와서,

## HTTP의 기본 통신 방식

### 단순한 구조

#### Request
#### Response

좀 더 자세히 보면

### HttpRequest

#### 1. Start line

방식 / URL / HTTP 프로토콜 버전 
POST /springweb/.. HTTP/1.1

#### 2. headers

...
content-type: -
등 잡다한 정보
...

#### 3. body
> request body
>> request를 보내는 놈의 body라는 의미

### HttpResponse

#### 1. Start line
<code>200</code>: success(성공)

<code>201</code>: create(생성됨)

<code>403</code>: forbidden(권한 없음)

<code>404</code>: not found(찾을 수 없음)

<code>415</code>: content-type이 다름

<code>500</code>: 서버 이상.

#### 2. headers

#### 3. body
> response body
>> request를 보내는 놈의 body라는 의미

response body에 json 넣어야 함 
stream 직접 여는 거 하면 안 됨 
jsp 안 씀 데이터만 보낼 것
즉 xml 아니면 json이 실림(일반적으로 json이 실림 )
클라이언트가 보낸 데이터를 받아 json으로 보냄 -> ajax

즉 기존 방식이냐 rest 방식이냐를 구분해 컨트롤러를 만들어주면 됨
컨트롤러는 두 가지 방식이구나
기존 jsp 처리 방식의 컨트롤러냐
레스트 기반의 api처럼 클라이언트가 결과만 받을 수 있는 rest 컨트롤러냐
지금부터는 후자의 내용을 진행 

암튼 바디 부분에 직접 데이터를 심기 때문에
그 데이터가 어떤 데이터인지를 명시하기 위한 것
그게 produces의 역할