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

### Abstract class
- class 안에 특별한 case
- class 안에 abstract method가 단 1개라도 있다면 이 class를 abstract class라고 부른다.

#### Abstract method
- method 안에 method 하는 일을 명시하지 않은 것

#### method 정의
```java
public void eat(){

}

// 일반 method 
```

#### method를 선언
```java
public void eat(); // abstract method
```

abstract method로 인한 abstract class는 제약이 존재합니다. class가 완성이 안 되어 있기 때문입니다. 따라서 instance를 생성할 수 없습니다.
