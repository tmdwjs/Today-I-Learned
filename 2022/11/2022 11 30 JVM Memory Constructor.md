### JVM 메모리 구조

- Stack
- Heap
- Method Area

> 인스턴스는 Heap에 만들어 집니다.

<img width="400" alt="image" src="https://user-images.githubusercontent.com/85447054/204761632-00090a41-31dd-407d-8671-1b406c55671d.png">


#### garbage collector

> JVM이 메모리의 불필요한 공간을 정리해주는 것을 의미합니다.

---

### static

instance 생성 없이 바로 method area에서 호출이 가능합니다. static 사용 시, static field를 지정하는 method도 반드시 static으로 지정해야 합니다.

<img width="400" alt="image" src="https://user-images.githubusercontent.com/85447054/204763484-b21e2e71-bc88-42cf-a17e-1cace9ec560c.png">

---

### overloading

- method overloading

method의 이름이 같아도 method의 인자 개수나 parameter 타입이 다른 경우, 다른 method로 구분합니다.

- constructor overloading
- operator overloading

---

### Access Modifier

- public
- protected
- package
- private

1. public과 package는 class 앞에 나오고, 안 나오면 package로 쓰인 것.
2. constructor, field, method 앞에 붙지만, <code>private</code>, <code>protected</code>는 class 앞에 못 붙음.
3. class가 public이어도, 안에 constructor, field, method가 public인 건 아님.

#### private 
information hiding
클래스 내부로 숨김(클래스 외부에서 access 할 수 없도록)

field는 information hiding을 위해 일반적인 경우 private으로 함

---

### static block

```java
static {
  // 프로그램에서 사용되는 라이브러리를 미리 로딩하고자 하는 경우에 사용
}
```
main method 이전에 실행됩니다. 주석과 같은 특별한 경우에 사용됩니다.

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

constructor에 private 생성자를 사용할 때가 있습니다. 일반적으로 private을 사용하면 다른 class에 의해 객체 생성이 안 되기 때문에 비효율적으로 보일 수 있지만, class로부터 instance를 딱 한 개만 만들 때 즉, <code>싱글톤 패턴</code>일 때 사용합니다.

---

### main method

```java
public static void main(String[] args) {

	}
```

main은 항상 static으로 잡혀 있어야 합니다. main이 가장 먼저 호출돼야 하기 때문입니다. 그리고 다른 package에서 main을 사용하기 위해 public을 같이 사용하는 것입니다.

---

### System.out.println("Hello world");

![image](https://user-images.githubusercontent.com/85447054/204765386-a9fbed8e-4bd7-4506-9856-ea58e24f19e2.png)
