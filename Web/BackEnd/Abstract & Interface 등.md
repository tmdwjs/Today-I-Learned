## 2022 12 02 Today I Learned

### fianl keyword
- class 앞에 붙을 수 있다
  - 이 class는 상슥 계층 구조도에서 제일 마지막에 위치한다
  - 이 class를 이용해 새로운 class를 확장시킬 수 없다

- field 앞에 붙을 수 있다
  - field를 상수화 시키는 것 > 값을 고정하고 변경할 수 없다
  - final field를 반드시 초기값을 지정

- method 앞에 붙을 수 있다
  - 하위 class

---

### Abstract

#### Abstract class
- class 안에 특별한 case
- class 안에 abstract method가 단 1개라도 있다면 이 class를 abstract class라고 부른다.

#### Abstract method
- method 안에 method 하는 일을 명시하지 않은 것

abstract method로 인한 abstract class는 제약이 존재합니다. class가 완성이 안 되어 있기 때문입니다. 따라서 instance를 생성할 수 없습니다.

define 시, abstract method가 abstract class로 전달되는데, 이때 <code>overriding</code> 하면 일반 class가 된다.

---

### Interface

class 간의 결합도를 낮출 수 있다.

```java
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

1. Class 간에 상속이 가능하며, Interface 간에도 상속이 가능하다.
2. Class가 Interface를 상속할 수 있나? -> 상속은 불가능함
3. 단, class는 interface를 구현(implement)할 수 있다.
```java
  interface A { }
  class B interface A { }
```
    
