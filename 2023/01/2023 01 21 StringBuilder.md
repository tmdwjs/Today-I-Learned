### StringBuilder

코딩 테스트를 풀며, 반복문을 돌리며 정답을 출력하니 시간 초과가 떴습니다. 이때 <code>StringBuilder</code>를 사용해, 문제를 통과할 수 있었습니다. <code>StringBuilder</code>는 이름 그대로 <code>String</code>을 더해 출력할 수 있습니다. 이때 <code>append()</code> 메서드를 사용합니다.

하지만 왜 그냥 <code>String</code> + <code>String</code>을 하지 않을까요? 그 이유는 <code>String</code> 객체는 메모리 할당과 해제를 발생시키는데, 덧셈 연산이 많아지면 성능적으로 좋지 않기 때문입니다.

<code>String</code> 객체는 한 번 생성되면 변경이 불가능합니다. 즉 문자열을 더할수록 기존 데이터에 더해 출력하는 게 아닌, 새로운 객체를 생성해 더한 값을 출력하기 때문에, 수천, 수만, 그 이상의 문자열을 연결해야 한다면 메모리를 많이 잡아먹을 수밖에 없는 것입니다.

```java
StringBuilder sb = new StringBuilder();
sb.append("문자열");
```