### Spring Container
<code>Spring Container</code> 중 중요한 역할을 수행하는 객체 하나가 있습니다. 이를 <code>Application Context</code>라고 합니다.

<code>Application Context</code>가 하는 가장 주요한 작업은 <code>Bean</code>을 생성하고 이 <code>Bean</code> 간의 관계를 설정하는 역할을 합니다. 따라서 <code>Bean</code>을 찍어내는 공장이라는 의미에서 <code>Bean Factory</code>라고 하며, <code>Bean</code>들을 유지하고 가지고 있기 때문에, <code>Applictaion Context</code>를 다른 말로 <code>Spring Container</code>라고 하는 것입니다.

실제 프로그램에서 내 로직에서 내가 객체를 관리하는 게 아니라, <code>Bean</code>이라고 불리는 객체를 관리하고 리턴하는 과정들을 <code>Application Context</code>가 해 주게 되는 것이고 이를 제어의 흐름이 바뀌었다고 해 <code>IoC(Inversion of Control)</code>즉 제어의 역전이라고 하며, <code>Spring IoC Container</code>라고도 합니다.

더 나아가 너무 광범위 한 개념에서 조금 더 자세히 들여다 보면 주요 작업이 의존성 주입(<code>DI(Dependency Injection)</code>)이기 때문에 <code>DI Container</code>라고도 할 수 있습니다.

### Bean
<code>Application Context</code>가 제어권을 가지고(=<code>IoC</code>) 직접 만들고 그 객체들 간에 관계(=<code>Dependency</code>)를 부여하는 객체를 의미합니다.

<code>Bean</code>은 <code>POJO(Plain Old Java Object)</code>입니다. <code>Spring IoC/DI Container</code>에 의해 생성하고 관계를 맺어지는 등 관리됩니다. 저희는 그저 그렇게 만들어진 <code>Bean</code>을 얻어다 사용하는 개념입니다.

<code>Bean</code>은 속성이 있습니다.

#### Bean의 주요 속성

1. Class
  - Bean으로 등록한 Java Class
2. ID
  - Bean은 ID를 가짐
  - 식별자로 사용됨
  - 단순 구분 목적이 아닌, Application Context에게 Bean을 요청할 때 사용됨
3. Scope
  - Singleton(Default)
    - Class마다 객체가 하나만 올라가는 것을 보장하는 것을 의미
  - Prototype
    - Singleton과 달리, 하나만 보장하는 게 아닌 필요할 때마다 만들어 올리는 것
    - Singleton과 Prototype의 차이
4. Constructor -arg
  - Bean 객체 생성 시 생성자에 전달한 인자를 표현
5. Property
  - Bean 객체 생성 시 Setter에 전달할 인자를 표현

#### Bean 설정 정보

지금까지 알아본 <code>Bean</code>을 사용하려면 설정 정보를 만들어야 합니다. 이때 설정 정보를 <code>Configuration MetaData</code>라고 합니다.

1. XML
  - 기본으로 Bean의 설정 정보를 관리하는 방식
  - Bean의 Dependency를 전부 XML로 관리
  - 즉 프로그램이 커지면 굉장히 복잡해진다
2. Annotation
  - 편하다
  - XML과 혼용해서 사용할 수 있다

XML(Configuration MetaData) -> 설정 -> Spring IoC Container가 사용(얘는 Container라고 표현할 뿐 하나의 객체임. 근데 이제 클 뿐)
<-> Applictaion(내 로직임. Spring IoC Container에게 Bean을 달라고 요청하는 것)

어떤 경우는 Container 안에 Bean을 만들어 두기도 하지만, Bean의 설정 정보만 가지고 있는 경우도 있음

#### Bean 등록 방법

1. 수동 방법
  - 외부 라이브러리를 Bean으로 등록해야 하는 경우
2. 자동 방법
  - 일반적으로 편하고 좋기 때문에 이 방법을 이용함

현재 수업에선 수동 방법으로 등록하는 방법을 알아보도록 하겠습니다.

```java
// 수동 방법

class MyResource {
  // 1. 얘는 Bean으로 등록하기 위한 주체이고,
  // 2. 우리는 얘를 등록하기 위한 설정 정보가 있어야 함
}

// 3. Annotation을 이용해 처리
@Configuration // @Component -> 자동 방법
// Annotation도 하위 Annotation이 있음
// 즉 Annotation도 상속 관계에 있는 것
// @Controller, @Service, @Repository, @Configuration
class MyResourceConfig {

  // 4. Bean을 만들어내는 Method
  @Bean
  // 수동 방법일 때 Bean의 ID는 getResource
  public MyResource getResource() {
    return new MyResource();

    // 5. 이러면 MyResourceConfig의 getResource 메서드를 호출하면,
    // 6. MyResource를 만들어 return 한다.
  }
}
```

### Singleton Registry
> Application Context의 기능 중 하나

그럼 왜 <code>Singleton</code>으로 <code>Bean</code>을 관리하는 걸까요? <code>Spring</code>은 <code>Server Side Application</code>을 구현하기 위해 사용합니다. 여러 클라이언트에 의해 공유되는 객체가 필요합니다. 이를 <code>Singleton</code>으로 처리해야 효율이 좋기 때문입니다.

여러 쓰레드에 의해 공유가 가능한 객체를 Bean으로 등록해 효율을 높이자는 거지, 프로그램의 모든 객체를 다 하자는 게 아님. stateless를 해야지 stateful은 하면 안됨 그렇기 때문에 VO는 Bean으로 사용하지 않음

### 의존 관계(Dependency)
> 두 개의 Class를 대상으로 하며, 방향성을 표시해야 함

두 개의 클래스 <code>A</code>와 <code>B</code>가 있습니다. 이 둘 사이에 의존성이 있다면, 이를 화살표로 방향성을 표시해야 합니다.
만약 <code>A</code> - - -> <code>B</code>와 같이 화살표로 방향성을 나타내면 이는 <code>A</code>가 <code>B</code>에 의존한다 할 수 있습니다.
이런 경우 <code>A</code>의 입장에서는 의존 대산인 <code>B</code>가 변하면 그 영향이 <code>A</code>에 미친다는 것을 의미합니다.

dependency injection은 두 가지가 있음 setter와 contructor(생성자)