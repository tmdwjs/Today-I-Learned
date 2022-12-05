### Java 주요 Class

#### Object Class
Java의 최상위 Class
- Constructor
- field
- method

#### 기억해야 하는 method
1. equals()
객체를 비교하는 용도로 사용

문자열 비교할 땐 '=='이 아닌, overriding 된 <code>equals</code>를 사용해야 더 정확한 값을 얻을 수 있습니다.

2. toString()
객체를 문자열로 표현할 때 사용

#### String class
- 정수
    - byte
    - short
    - int
    - long
- 실수
    - float
    - double
- 문자
    - char
        - 한 글자(' ') 사용
- boolean

String의 또 다른 특징
immutable(불변의) <-> mutable(가변의)

### Array
> 집합 자료 구조

거의 대부분의 프로그래밍 언어가 가지고 있는 기본 자료 구조입니다.

#### 특징
1. 여러 개의 연속적인 저장 공간
2. 배열은 객체(Heap에 존재) > new를 이용해 생성
3. 배열 사용은 당연히 index를 이용
4. 각각의 저장 공간은 같은 data type을 가진다
5. 배열 생성 후, 크기를 조절할 수 없다

```java
int[] a = new int[4];
// or
int a[] = new int[4];
```

#### 단점
1. 같은 data type만 가능
2. 크기가 고정돼 있어 사용이 힘듦

### ArrayList
> 자바가 제공해주는 class <code>java.util</code>에 존재

#### 특징
1. 서로 다른 data type 데이터 지정
2. 배열과 유사한 생김새
3. 크기가 고정돼 있음
4. 단, reference type만 저장 가능
    1. 즉, primitive type(100, 3.14, true, 'H')는 저장이 안 됨
    2. 만약 100 등 primitive type을 지정해주고 싶으면 어떻게 해야 할까?

### Wrapper Class
> Java가 제공해주는, Primitive type와 매핑하는 class

primitive type <-> wrapper class
int <-> Integer
double <-> Double
...

### Generic
> 고정된 data type을 표현해주는 것

ArrayList 사용 시, 대부분 같은 DataType를 사용하는 것을 발견할 수 있습니다. 원래는 다른 data type들이 ArrayList 안에 나오는데, 이를 고정시키고자 했고,
이때 사용하는 게 <code>Generic</code>입니다.
