function solution(numbers) {
  var answer = 0;
  
  for (let i = 1; i <= 9; i++) {
      if (!numbers.includes(i)) {
          answer += i
      }
  }
  
  return answer;
}