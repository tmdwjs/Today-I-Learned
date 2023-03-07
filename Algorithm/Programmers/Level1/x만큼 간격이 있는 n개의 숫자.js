function solution(x, n) {
  let answer = [];
  
  // n만큼 반복문 돌리기
  
  for(let i = 1; i <= n; i++) {
      answer.push(x*i)
  }
  
  return answer
}