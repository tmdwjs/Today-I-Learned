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

#### 풀이

// splice(현재, 현재-2) > 즉 2자씩 나눈다는 의미.
// 나와 내 앞까지 구하므로 반복문 시 length의 -1만큼 반복문을 돌려야 한다.

// 대소문자 상관 안 한다 > toUpperCase or toLowerCase
// Math.floor(교집합 수/합집합 수*65536)

// ab+ > ab/b+ > b+은 버림.
// 이게 자른 후에 담으면서 버려야 할지, 먼저 버린 후에 자를지 고민해야 한다.
// aabc+dde > aabcdde > aa/ab/bc/cd/dd/de > 6개
// aabc+dde > aa/ab/bc/c+/+d/dd/de > aa/ab/bc/dd/de > 5개
// 자른 후 알파벳만 남기면 될 것 같다.

// 알파벳만 남기고 잘라서 return 해 주는 함수를 만든다.
// 두 개씩 자른 후 정규표현식으로 알파벳만 걸러주고 소문자로 변환 후 배열에 담아 return.

#### 코드

```js
function solution(str1, str2) {
  let validStr1 = valid(str1); // [ 'fr', 'ra', 'an', 'nc', 'ce' ]
  let validStr2 = valid(str2); // [ 'fr', 're', 'en', 'nc', 'ch' ]
  // 교집합 [fr, nc]
  // 합칩합 [fr, ra, an, nc, ce, re, en, ch]
  
  let intersectionsLength = 0; // 교집합 수
  let unionLength = 0; // 합집합 수
  
  let union = new Set([...validStr1, ...validStr2]);
  
  union.forEach(elem => {
      
    let filterStr1 = validStr1.filter(v => v === elem).length;
    let filterStr2 = validStr2.filter(v => v === elem).length;

    intersectionsLength += Math.min(filterStr1, filterStr2);
    unionLength += Math.max(filterStr1, filterStr2);
  })
  
  return intersectionsLength === unionLength ? 65536 : Math.floor((intersectionsLength/unionLength)*65536);
}


function valid(str) {
  const regex = /^[a-z|A-Z]+$/; // 문자열에 알파벳만 확인
  const arr = [];
  
  for(let i = 0; i < str.length-1; i++){
    const slice = str.slice(i, i+2); // 2자씩 slice
    // 2자씩 자른 문자가 전부 알파벳이면 배열에 소문자로 변환 후 담아준 뒤,
    if(regex.test(slice)) arr.push(slice.toLowerCase());
  }
  
  return arr;
}
```

### [프로그래머스] 스티커 모으기(2)(자바스크립트/레벨 3)

#### 문제

https://school.programmers.co.kr/learn/courses/30/lessons/12971

#### 풀이

// 가장 큰 수를 떼는 게 중요한 게 아니라,
// 큰 수를 뗌으로써 마지막과 두 번째가 나가리 되면 의미 없음.

// 첫 번째 선택 시 마지막 선택 못함
// 첫 번째 선택 안 할 시, 마지막 선택 가능
// 첫 번째 선택 or 두 번째 선택
// 두 개 경우의 수를 다 돌려보고, 더 큰 수를 return.

// 일단 초기화를 한다. 0에서부터 시작해 더해야 하니까
// 현재 = 직전 vs 2번째 전 + 현재
// i = i - 1 vs i - 2 + sticker[i]
// 첫 번째 선택 시 i - 2가 음수가 되면 안 되니 sticker의 length에 +2만큼 해 주기.

#### 코드

```js
function solution(sticker) {
  const size = sticker.length+2;
  const dp1 = new Array(size).fill(0);
  const dp2 = new Array(size).fill(0);

  // early return
  // sticker가 한 장인 경우 해당 스티커 숫자를 return
  if(sticker.length === 1) return sticker[0];
  
  // 첫 번째 스티커를 뜯었을 시.
  // 마지막은 뜯지 못 하므로 size-1만큼 반복문을 돌린다.
  for(let i = 2; i < size-1; i++){
    dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i-2])
  }
  
  // 두 번째 스티커를 뜯었을 시.
  for(let i = 3; i < size; i++){
    dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i-2])
  }
  
  // return 더 큰 수(첫 번째 스티커 뜯은 경우, 두 번째 스티커 뜯은 경우)
  return Math.max(dp1[size-2], dp2[size-1]);
}
```
