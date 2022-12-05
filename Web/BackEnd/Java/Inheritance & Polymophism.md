## 2022 12 01 Today I Learned

### Inheritance(상속)
> class를 정의할 때 기존의 다른 class를 확장해서 class를 정의하는 방법

#### 상속이 안 되는 경우
- constructor
- private

Java의 최상위 class는 <code>java.lang.Object</code>. Java에서 나오는 모든 class는 Object를 상속합니다. Object는 최상위 class이기 때문에 Java에서 나오는 모든 Class는 상속 관계입니다.

---

### Polymorphism(다형성)
객체는 Data Type에 따라서 여러 형태로 사용될 수 있습니다.(IS-A 관계에 의해)

### super()

> 상위 class의 생성자를 호출하는 메서드.

constructor 안에서 가장 먼저 나오는 코드이며, <code>super()</code>를 호출하고, 상위 class에게 매개변수를 전달할 수 있습니다.

### this()
> 현재 class의 또 다른 생성자를 호출할 때 사용.

---

### memory 구조
- Method area
  - class 정보가 저장되는 곳
- Stack
  - method 실행을 위한 공간
- Heap
  - instance를 생성하기 위한 공간

### method overriding

상속 받은 상위 class method를 하위 class에서 재정의 합니다. dynamic biding(동적 바인딩)이라고도 합니다.

---

### 배열(Array)
> 가장 기본적인 자료 구조로, 같은 데이터 타입으로 구성된 연속적인 저장 공간

Java의 경우, Array보다는 Array list 같은 collection 계열을 이용합니다.