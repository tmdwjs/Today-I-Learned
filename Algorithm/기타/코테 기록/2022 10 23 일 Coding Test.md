# 프로그래머스

## 문제

[타겟 넘버(자바스크립트/레벨 2)](https://school.programmers.co.kr/learn/courses/30/lessons/43165)

## 코드

```js
function solution(numbers, target) {
  // numbers의 length만큼 반복문 돌아야 한다.
  // numbers의 요소를 다 탐색한 상태에서 target과 같으면 answer를 카운팅 한다.

  let answer = 0; // target과 같아질 때마다 누적해 return 할 answer
  dfs(0, 0);

  function dfs(depth, acc) {
    if(depth < numbers.length){
      dfs(depth + 1, acc + numbers[depth]);
      dfs(depth + 1, acc - numbers[depth]);
    }else {
      if(acc === target) answer ++;
    }
  }

  return answer;
}
```