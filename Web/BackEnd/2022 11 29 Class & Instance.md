### Namespace
> 유니크한 이름을 구분해줄 수 있는 식별자

### Package

> class를 논리적으로 묶는 개념

class 사용 시, package를 명시해야 합니다.

#### default package

명시하지 않으면 default package라는 특수한 package에 포함됩니다. 자바에서 나오는 모든 class는 반드시 package로 묶어서 구현해야 하나, 명시하지 않으면 결국 default package로 묶이게 되고, default package는 지양하도록 합니다.

#### package 네이밍 구조

- damain의 역순으로 구성해 계층 구조를 이룬다.<br>
  - e.g. www.abc.or.kr → kr.or.abc.프로젝트이름

- pacakge를 물리적으로 묶을 땐 folder로 구분이 된다.<br>
  - e.g. kr.or.abc.프로젝트명

<pre>
kr
 ┣ or
 ┣ ┣ abc
 ┃ ┣ ┣ 프로젝트명
 </pre>

---

### Modeling

**고객(개념, 관념)**
- 홍길동
- 김민수
- 손흥민

**실체**
- 상태값
  - 이름
  - 나이
  - 전화번호
  - 계좌번호
- 행위
  - 입금한다
  - 출금한다

> 고객이라는 개념을 class로 표현한 것.

----

### Class

```java
1. constructor 생성자
2. Field 상태
- 변수로 표현(변수의 집합)
3. method 행위
- 함수로 표현(함수의 역할을 하는 것)
- 일련의 코드 묶음
```

1. 객체 modeling의 수단
2. ADT(Abstract Data Type)
3. Instance 생성 역할

![image](https://user-images.githubusercontent.com/85447054/204759245-b69fb972-31e4-433b-b2dd-dcfd82307644.png)

---

### Instance

- 개념과 관념 등 실제로 존재하는 거 객체(Object)
- 이를 class에서 모델링 해 주는 것 인스턴스(Instance)
- 데이터를 저장하는 memory 공간 + 코드를 실행 가능

**instance는 메모리 공간**입니다. ???라는 메모리 주소를 따라가 보면 인스턴스가 존재하기 때문에 ???라는 인스턴스는 메모리 주소값을 가지고 있다 볼 수 있습니다.이름부터 메모리 주소를 **'참조'하기 때문에 reference data type**이라고 하는 것입니다.

하지만 java에서 보안 상 실제 메모리 주소를 알아낼 수 없습니다. 즉, 인스턴스가 참조하는 메모리 주소는 메모리 주소의 <code>해쉬값</code>을 참조하는 것입니다.

![image](https://user-images.githubusercontent.com/85447054/204758108-43605a7b-553b-4496-85d5-5b97d1b6da96.png)

---

### Data Type

- 메모리 공간의 크기를 잡고 값의 종류를 제한해주는 것이 Data Type이다.
  - Data는 메모리 공간에 저장
  - OS로부터 불러온 JVM이 관리하는 Memory
  - Java는 Strong Type Language(강 타입 언어)
  - 데이터 타입을 반드시 명시해줘야 한다.

#### Java의 Data Type 
- Primitive Data Type
  - byte(1 byte)
  - short(2 byte)
  - int(4 byte)
  - long(8 byte)
  - float(4 byte)
  - double(8 byte)
  - char
  - boolean

- Reference Data Type
  - class

---

### 변수
- 대소문자 구분, 길이 제한 없음
- 예약어는 식별자 사용이 안 됨
- 숫자 사용 불가
- 특수문자(_ 와 $만 가능)

---

### Import

Primitive Data Type을 벗어나는 타입(String) 즉 Reference Data Type입니다. 따라서 String과 같은 건 자바에서 제공하는 내장 Class입니다.(Class Library) 사용할 때 package처럼 명시해야 하지만, 매번 라이브러리를 명시하기엔 코드가 길어지고 힘들어 이때 사용하는 것이 <code>import</code> 구문입니다.

class로부터 **instance를 파생하기 위해** <code>new 키워드</code>를 반드시 사용 + 생성자가 따라 나와야 합니다.

---

### Main Method

엔트리 포인트 즉 main 메서드가 있어야 됩니다. main은 class 안에 존재하기 때문에, main 메서드를 위해 더미 class를 생성합니다.

---

### dot operator(점 연산자)

field는 instance마다 각각 공간이 따로 생상됩니다.

---

### this

객체 지향에서의 this는 **현재 사용하는 객체의 reference**를 의미합니다.

#### 객체 지향의 information hiding

필드에서 public 사용 시, 아무 패키지에서 데이터 접근이 가능하기 때문에, 특별한 경우가 아니고서야 public을 지양해야 합니다.

---

```java
// Customer.java

package bank;

public class Customer {
	// constructor
	public Customer(String name) {
		this.name = name;
	}
	
	// field
	public String name; // 고객 이름 > instance variable
	public String accountNumber;  // 고객 계좌번호 > instance variable
	public long balance;  // 잔액 > instance variable
	
	// method
	public long getBalance() {
		return this.balance;
	}
	
	// void = return 값이 없음
	public void deposit(long money) {
		this.balance += money;
	}
	
	public long withdraw(long money) {
		if(this.balance < money) System.out.println("잔액 부족");
		else this.balance -= money;
		
		return this.balance;
	}
}

```

```java
// Main.java

package main;

import bank.*; // bank로부터 패키지 import

public class Main {
// method는 entry point인 main method만 존재

	public static void main(String[] args) {
//		Customer hong = new Customer();
//		hong.name = "홍길동";
		
		Customer hong = new Customer("홍길동");
		
		// 잔액 확인
		long result = hong.getBalance();
		System.out.println("초기 잔액은: " + result);
		
		// 입금
		hong.deposit(2000);
		result = hong.getBalance();
		System.out.println("입금 후 잔액은: " + result);
		
		// 출금
		hong.withdraw(1000);
		result = hong.getBalance();
		System.out.println("출금 후 잔액은: " + result);
	}
}

```
