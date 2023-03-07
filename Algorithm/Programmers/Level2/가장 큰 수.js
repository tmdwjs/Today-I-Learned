function solution(numbers) {

  let string = numbers.map(a => a + ""); // 문자열로 변경
  let answer = string.sort((a, b) => (b + a) - (a + b)).join('');
  return answer[0] === '0' ? '0' : answer;
}