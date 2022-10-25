## TIL 2022 10 25

### [프로그래머스] 튜플(자바스크립트/레벨 2)

#### 문제

https://school.programmers.co.kr/learn/courses/30/lessons/43165

#### 코드

```js
function solution(s) {
  let answer = []; // 배열 형태가 답이라 빈 배열에 담아서 return 한다.
  let setting = s
    .slice(2, -2) // 중괄호까지 문자열로 들어오기 때문에, slice 메서드를 사용해 중괄호를 제거하고,
    .split('},{') // 중간 중간 }, {를 제거하기 위해 split 메서드를 사용한다.
    .map(i => i.split(',').map(v => Number(v))) // ','로 split > 배열 만든 후 문자열 > 숫자로 형변환
    .sort((a, b) => a.length - b.length) // 오름차순
    // 튜플 표현 배열이 후에는 뒤죽박죽이어도 인정되만, 한 개만 입력된 배열은 무조건 해당 튜플의 첫 스타트이기 때문에,
    // 오름차순 한 뒤 먼저 정답 배열에 담아주면서 튜플을 유추해야 한다.
    
    .forEach(arr =>
      // 배열 각각 한 번 더 forEach 돌려준다.
      arr.forEach(num => {
          if(!answer.includes(num)) answer.push(num);
      })
    )
  
  return answer;
}
```

### [프로그래머스] [1차]뉴스클러스터링(자바스크립트/레벨 2)

#### 문제

https://school.programmers.co.kr/learn/courses/30/lessons/17677


#### 코드
