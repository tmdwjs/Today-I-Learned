## 2022 11 30 Today I Learned

### JVM 메모리 구조

- Stack
- Heap
- Method Area

인스턴스는 무조건 Heap에 만들어진다

#### garbage collector
JVM이 메모리의 불필요한 공간을 정리해주는 것을 의미한다.

---

### static

static field를 지정하는 method도 반드시 static으로 지정해야 한다.

### class의 나머지 내용

- method overloading
- package & import
- Accese Modifier(접근 제어자) public
- static block

### overloading

- method overloading

method의 이름이 같아도 method의 인자 개수나 parameter 타입이 다른 경우, 다른 method로 구분


- constructor overloading
- operator overloading


### Access Modifier
- public
- protected
- package
- private

1. public과 package는 class 앞에 나오고, 안 나오면 package로 쓰인 것.
2. constructor, field, method 앞에 붙지만, <code>private</code>, <code>protected</code>는 class 앞에 못 붙음
3. class가 public이어도, 안에 constructor, field, method가 public인 건 아님

#### private 
information hiding
클래스 내부로 숨김(클래스 외부에서 access 할 수 없도록)

field는 information hiding을 위해 일반적인 경우 private으로 함

---

### class

#### constructor
- constructor overloading을 통해 일반적으로 여러 개 사용

#### field
- static field(class variable)
  - 모든 instance가 하나의 field를 공유한다.
- static 아닌 field
  - instance 각자가 field를 생성
  - private으로 access modifier를 설정한다.
    - information hiding 때문에
    - 외부 class에서 field에 대한 직접적인 접근을 막기 위해

#### method
- private field 사용이 가능하기 위해 public으로 설정
  - getter, setter
  - business method
    - 우리 field 값을 이용해 로직 처리
    - field 값을 적절하게 변경

데이터 + 기능: <code>encaptulation(캡슐화)</code>
