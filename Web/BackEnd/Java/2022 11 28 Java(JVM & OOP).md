# Java

## 언어

<code>C</code> <code>C++</code> <code>C#</code>: hardware 제어, low level

<code>Java</code>: 객체지향 가장 잘 반영 > 유지보수성↑, 재활용성↑ > 기업용 Application 개발에 적합하다.

<code>Python</code>: / AI, 데이터 분석

<code>JavaScript</code>: FrontEnd Web Application

## 동작 방식

### 일반적인 방식

<pre>
Operating System(OS, 운영체제) → Platform
Computer → Hardware
</pre>

사람 Code → compile  → 기계어(machine code)
compiler를 통한 compile

### Java 동작 방식

사람 Code → compile  → byte code
이때, os가 byte code를 인식할 수 없기 때문에, JVM이 필요합니다.

> java source 코드 > xxx.java = 사람이 인식<br>
> byte code의 확장자 > xxx.class = 바이트 코드, 아무도 인식 불가 

![image](https://user-images.githubusercontent.com/85447054/204756634-431b8947-0d48-49d4-870e-acacf5d56983.png)

## JVM(Java Virtual Machine)

<pre>
JVM
Operating System(OS, 운영체제) → Platform
Computer → Hardware
</pre>

JVM → 자바 가상 기계 → Program이자 Platform
bytecode를 읽어서 실행하는 방식 → <code>interpreter</code>

따라서, 자바 코드를 실행하려면
1. compiler → bytecode = javac.exe
2. interpreter → 기계어 = java.exe

### 장점
- OS에 독립적이다.

### 단점
- 메모리 사용 및 실행 속도가 느릴 수 있다.
  - 단, 현재는 기술의 발달로 단점으로 언급되지 않음.

### 특징
- Write once, Run anywhere(WORA)
- JVM은 OS에 종속된다.

![image](https://user-images.githubusercontent.com/85447054/204756942-0b8f7d9b-58ed-4231-89cf-76ee3e02d9eb.png)

<code>JDK</code>: Java Development Kit(자바 개발 도구 = JRE + 프로그래밍에 필요한 툴(Compiler 등))

<code>JRE</code>: Java Runtime Environment(자바 실행 환경 = JVM + Java Class Library)

<code>JVM</code>: Java Virtual Machine

<code>JDK 1.0.2</code> <code>JDK 1.1</code> ... <code>JDK 5</code> ... <code>JDK 8</code> ... <code>JDK 11</code> ... <code>JDK 18</code>

## 구조적 프로그래밍(절차적 프로그래밍)


> 프로그램을 기능으로 분류해서 구현<br> <code>C</code>

### 장점 
- 분석, 설계가 쉽다.
- 구현이 용이하다.
- 비용 절감이 가능하다.

### 단점
- 유지보수가 어렵다.

## 객체지향 프로그래밍

> 현실에서 해결해야 할 문제를 그대로 프로그램으로 표현하자 = 모델링(modeling)<br>
> <code>Java</code> <code>C++</code> <code>C#</code> <code>Python</code> <code>JavaScript</code>

### 장점 
- 유지보수가 쉽다.

### 단점
- 설계가 어렵다.

<pre>
고객
- 이름
- 키
- 몸무게
- 혈액형
- 팔 길이
- 손가락 길이
- ...
- SNS 주소

이를,
- 이름
- 번호
- 계좌번호
</pre>

이를 객체 지향에서 <code>추상화(Abstraction)</code>라고 하며, 이때 추상화 후 모델링 하는 도구가 <code>클래스</code>라고 합니다.

## Class 
> 현실의 객체를 추상화 해서 프로그램적으로 모델링 하기 위한 수단 = 객체 모델링의 수단

### Class 구조
```java
public class Class{
  // constructor(생성자)
  // field(0개 이상 존재)
  // Method(0개 이상 존재)
}
```

## Eclipse

1. workspace 설정
2. 한글 encoding > UTF-8 설정
3. Perspective 설정

## Java Application

### 프로젝트 생성
- 프로젝트는 여러 개의 java source code(xxx.java)가 모여서 구성된다.
- 이 java source file 안에는 한 개의 class가 원칙
  - 왜? 재활용 하기 편하기 때문에
  - 하지만 여러 개의 class가 포함될 수는 있음
    - class끼리 의존성을 가지고 있으면 가능
    - 단, public class는 한 개의 file 당 많아야 한 개
      - 즉, 없거나 1개만 나올 수 있고, 만약 나온다면 file명을 따른다.
      - public이 없으면 file명은 아무거나

### Naming Convention
- PascalCase
- camelCase
- snake_case
