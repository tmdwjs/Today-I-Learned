// https://school.programmers.co.kr/learn/courses/30/lessons/17677

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
  
  return arr; // return
  
}