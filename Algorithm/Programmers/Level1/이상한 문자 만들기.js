function solution(s) {
  return s.split(' ') // 공백 문자 기준 split
      .map(el => el.split('') // 문자 하나씩 split
          .map((el, index) => index % 2 == 0 ? el.toUpperCase() : el.toLowerCase())
          // 배열이 짝수니(2로 나눴을 때 나머지가 0) ? 요소.대문자() : 요소.소문자()
          .join('')) // 문자 하나씩 join
  .join(' ') // 공백 문자 기준 join
}