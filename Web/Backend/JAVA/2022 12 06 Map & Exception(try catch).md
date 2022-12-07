### ArrayList

- List 계열
  - ArrayList Class
  - ...

-  Map 계열
  - HashMap Class

- Set 계열
  - HashSet Class

#### HashMap Class

- 데이터를 저장할 때 <code>key</code>: <code>value</code> 쌍으로 저장한다.
- List(ArrayList) 계열은 데이터의 순서가 있지만,
  - Map은 key를 통해 data를 제어하는 구조라 순서가 없다.
  - (하지만 순서를 보장하는 방법이 있음)
- key와 value를 instance(객체)로 사용

```java
package test;

import java.util.*; // HashMap 사용을 위해 import

public class MapTest {
  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<String, String>();
    
    map.put(key, value);      // Map 값 넣기
    map.get(key);             // Map 값 가져오기
    map.size();               // Map 크기 확인 
    map.replace(key, value);  // Map 안에 내용 변경
    ...
  }
}
```

#### HashSet Class
- 데이터 저장에 순서가 없다.
- instance 객체의 value만 저장한다.
- 중복을 배제한다.

```java
package test;

import java.util.*;

public class SetTest {
  public static void main(String[] args) {
    HashSet<String> set = new HashSet<String>();
    
    set.add(value);     // Set 값 넣기
    set.remove(value);  // Set 값 삭제
  }
}
```

---

### Exception

compile time(source code를 작성하는 시점)에는 문제가 없는데, runtime 시 예외적인 상황이 발생되는 걸 의미합니다. 이때 프로그램이 **강제 종료(exception)** 이 발생하는데,
이를 해결하기 위해 강제 종료 되지 않도록 처리해야 합니다. 이를 <code>Exception Handling</code>이라고 합니다.

#### Exception에 관련된 class
- Exception
  - 모든 Exception class의 최상위 class
- NullPointerException
- ArithmaticException

#### Exception Handling

### Try Catch
```java
try {
  // code
  
// catch 구문 여러 개 가능
}catch(처리 할 exception) {
  // code
}catch(처리 할 exception) {

}catch(처리 할 exception) {

}finally(){
  // exception이 있거나 없거나 무조건 실행
}
```

#### throw
> 의도적으로 exception을 발생시키기 위해 사용

```java
class MyClass extends Exception{
	// Exception 객체 생성
}

public class CustomException {
  public static void main(String[] args) {
    try{
    
      // throw
      throw new MyClass();
      
      // 가장 최상위 Exception의 최상위 class.
      // 최상위 class인 만큼 모든 예외 처리가 가능하다.
    }catch(Exception e) {

    }
  }
}
```

로직 코드는 대부분 method 안에서 나오기 때문에, method 안에서 try catch 구분을 작성해야 합니다. 이때 try catch 구문이 너무 많이 작성되는 경우가 있는데, 이때 method는 자기를 호출한 곳으로 exception을 throw 할 수 있습니다. 

```java
public class CustomException {

  // Exception으로 throws
  public static void main(String[] args) throws Exception{

    System.out.println("시작");
    throw new MyClass(); // exception 발생
    
    // exception 발생 이후, throws만 했지 아직 로직으로 해결한 게 아니라
    // unreachable code라는 error 발생
    System.out.println("종료");
    
  }
}
```
