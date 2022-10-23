## TIL 2022 10 23

주말이라 살짝 쉬어 갔습니다.

노력이 조금씩 빛을 발하듯 운 좋게 1차에 붙어 코딩 테스트 일정이 몇 개 잡혀 있습니다. 정말 오랜만에 프로그래머스에서 코딩 테스트를 풀었습니다.

### 문제

https://school.programmers.co.kr/learn/courses/30/lessons/43165

### 코드

```js
// 프로그래머스 / 타겟 넘버 / 자바스크립트 / 레벨 2

function solution(numbers, target) {
  // numbers의 length만큼 반복문 돌아야 합니다.
  // numbers의 요소를 다 탐색한 상태에서 target과 같으면 answer를 카운팅 합니다.

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
