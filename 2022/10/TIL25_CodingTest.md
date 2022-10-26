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

<code>splice()</code> 메서드를 사용하여 2자씩 나눠줍니다.
이때 <code>splice(현재, 현재-2)</code>와 같이 사용해주면 될 것 같습니다.
나와 내 앞까지 구하므로 반복문 시 length의 -1만큼 반복문을 돌려야 합니다.

대소문자 상관 안 한다 했으니 <code>toUpperCase</code> 혹은 <code>toLowerCase</code> 둘 중 아무거나 선택하여 통일하고 문제 풀이를 진행합니다
마지막으로 <code>교집합 수 / 합집합 수 * 65536</code>를 하여 return 해 주는데, 이를 <code>Math.floor()</code>에 담아 내림하여 return 합니다.

매겨변수에는 알파벳과 기호가 섞여 있습니다. 만약 임의로 <code>aabc+dde</code>가 매개변수로 넘어왔다고 가정하겠습니다.
이게 자른 후에 담으면서 기호를 버려야 할지, 먼저 기호를 버린 후에 자를지 고민해야 하는데요.

**기호 선 삭제 및 자르기**

<code>aabc+dde</code> > <code>aabcdde</code> > <code>aa</code> <code>ab</code> <code>bc</code> <code>cd</code> <code>dd</code> <code>de</code> > 6개

**자른 뒤 기호 미 포함**

<code>aabc+dde</code> > <code>aa</code> <code>ab</code> <code>bc</code> <code>c+</code> <code>+d</code> <code>dd</code> <code>de</code> > <code>aa</code> <code>ab</code> <code>bc</code> <code>dd</code> <code>de</code> > 5개

이처럼 순서에 따라 결과가 다르게 나오고, 문제에서 제시한 것처럼 먼저 문자를 자른 뒤 기호가 포함돼 있는 문자를 제거해주는 방법으로 수행해 줘야 합니다.

알파벳만 남기고 잘라서 return 해 주는 함수를 만듭니다. 먼저 받아오는 매개변수를 해당 함수로 전송합니다. 함수를 거쳐 나오면 두 개씩 자른 후, 정규표현식으로 알파벳만 걸러주고 소문자로 변환 후 배열에 담긴 형태로 return 됩니다. 해당 데이터를 가지고 이어 풀이를 진행했습니다.

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

<code>첫 번째 선택 시</code> 두 번째와 마지막 스티커를 떼는 게 불가능 합니다.
<code>두 번째 선택 시(= 첫 번째 선택 x)</code> 마지막 선택이 가능합니다.
<code>세 번째 선택</code>부턴 첫 번째와 같기 때문에, 첫 번째 스티커와 두 번째 스티커를 제거하는 경우의 수만 구한 뒤, 이 둘을 비교하면 됩니다.

<code>dp[i]</code> = <code>dp[i-1]</code> vs <code>dp[i-2]</code> + <code>sticker[i]</code>

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

### 참고

[[프로그래머스] LV.3 스티커 모으기 (JS)](https://velog.io/@longroadhome/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-LV.3-%EC%8A%A4%ED%8B%B0%EC%BB%A4-%EB%AA%A8%EC%9C%BC%EA%B8%B0-JS)
