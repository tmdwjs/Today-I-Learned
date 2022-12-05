### fianl keyword
- class 앞에 붙을 수 있다.
  - 이 class는 상슥 계층 구조도에서 제일 마지막에 위치한다.
  - 이 class를 이용해 새로운 class를 확장시킬 수 없다.

- field 앞에 붙을 수 있다.
  - field를 상수화 시키는 것 > 값을 고정하고 변경할 수 없다.
  - final field를 반드시 초기값을 지정한다.

- method 앞에 붙을 수 있다.

---

### Abstract(추상화)

#### Abstract class(추상화 클래스)
- class 안에 특별한 case.
- class 안에 abstract method가 단 1개라도 있다면, 이 class를 <code>abstract class</code>라고 부른다.

#### Abstract method(추상화 메서드)
> method 안에 method 하는 일을 명시하지 않은 것을 의미합니다.

abstract method로 인한 abstract class는 제약이 존재합니다. class가 완성이 안 되어 있기 때문입니다. 따라서 instance를 생성할 수 없습니다. define 시, abstract method가 abstract class로 전달되는데, 이때 overriding 해 <code>일반 class</code>로 만들 수 있습니다.

---

### Interface

```java
// Class

public class A {
  // constructor
  
  // field
  private int k = 100;
  
  // method
    // getter & setter
    
    // business method
      // 일반
      // abstract
}
```

```java
// Interface

 // constructor X
 
 // field
 public static final int k = 100;
 // public static final 무조건 붙으며, 생략 가능
 
 // method
  // getter & setter X
  
  // business methos
  public abstract print();
  // abstract method만 존재
  // public abstract 생략 가능
```

- Class 간에 상속이 가능하며, Interface 간에도 상속이 가능하다.
- Class가 Interface를 상속할 순 없다.
- 단, Class는 interface를 구현(implements)할 수 있다.

```java
// implements

  // A.java
  interface A { }

  // B.java
  class B implements A { }
```
    
