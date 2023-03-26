# StringBuilder

반복문을 돌리며 정답을 출력하니 시간 초과가 떠 한 번에 합쳐서 출력할 일이 있었습니다. 이때 <code>StringBuilder</code>를 사용해 문제를 해결했습니다. <code>StringBuilder</code>는 이름 그대로 <code>String</code>을 더해 출력할 수 있습니다. 더할 때 <code>append()</code> 메서드를 사용합니다.

단순 문자열을 더할 때 <code>String</code> + <code>String</code>을 해 출력한다면, <code>String</code> 객체는 메모리 할당과 해제를 발생시키기 때문에 덧셈 연산이 많아지면 성능적으로 좋지 않을 수 있습니다.

<code>String</code> 객체는 한 번 생성되면 변경이 불가능합니다. 따라서 문자열을 더할수록 기존 데이터에 더해 출력하는 게 아닌, 새로운 객체를 생성해 더한 값을 출력하기 때문에, 수천, 수만, 그 이상의 문자열을 연결한다면 메모리를 많이 잡아먹을 수밖에 없는 것입니다.

```java
StringBuilder sb = new StringBuilder();
sb.append("문자열");
```

## 수행 시간 차이

```java
// String
// 0 ~ 10만까지 반복문 실행(총 3회)
// 수행 시간: 약 2951ms
public class Main {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
		
    String str = "";
		
    for (int i = 0; i < 100000; i++) {
      str += i;
    }

    long end = System.currentTimeMillis();
		
    System.out.println("수행 시간: " + (end - start) + " ms");
	}
}
```

```java
// String Builder
// 0 ~ 10만까지 반복문 실행(총 3회)
// 수행 시간: 약 4.6ms
public class Main {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
		
    StringBuilder sb = new StringBuilder();
		
    for (int i = 0; i < 100000; i++) {
      sb.append(i);
    }

    long end = System.currentTimeMillis();
		
    System.out.println("수행 시간: " + (end - start) + " ms");
	}
}
```