### XML
> XML 파일이 있어야 한다

<code>XML</code>은 문서의 구조가 미리 정해진 형태로 만들어졌는지 검증하는 기능이 있습니다. 즉 어떤 <code>XML</code>이냐에 따라 사용 가능한 태그와 태그의 구조로 이미 결정돼 있습니다. 이 검증은 두 가지로 작업 수행이 가능합니다.

1. DTD
2. Schema

<code>Schema</code>를 사용하면 네임스페이스를 이용해 추가적인 기능을 포함할 수 있기 때문에, 확장성이 더 큽니다. 따라서 스키마를 사용하는 것을 추천합니다. 그럼 이 파일은 어디에 만들어야 할까요? 어디에 만들어도 상관 없지만, 해당 과정에서는 <code>dao</code> 패키지 안에 생성하도록 하겠습니다.

> New - Spring Bean Configure File

통상 <code>xml</code>의 파일명은 <code>beans.xml</code> 혹은 <code>applicationContext.xml</code>로 지정해 줍니다.

### XML 설정