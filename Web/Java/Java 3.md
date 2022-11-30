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
- Public
- Protected
- Package
keyword가 없음
- Private

public과 package는 class 앞에 나옴
안 나오면 package로 쓰인 것

private protected
class 앞에 못 붙음

넷 전부
constructor, field, method 앞에 붙지만,
private, protected는 class 앞에 못 붙음
