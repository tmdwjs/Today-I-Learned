// https://school.programmers.co.kr/learn/courses/30/lessons/120956

// 문제에서 제시한 4가지 발음
// aya, ye, woo, ma

function solution(babbling) {
  const regexp1 = /(aya|ye|woo|ma)\1+/;
  const regexp2 = /^(aya|ye|woo|ma)+$/;
  
  return babbling.reduce((ans, word) => (
    !regexp1.test(word) && regexp2.test(word) ? ++ans : ans
  ), 0);
}