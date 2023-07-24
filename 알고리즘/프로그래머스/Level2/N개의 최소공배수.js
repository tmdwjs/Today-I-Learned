function solution(arr) {
  let answer = 1;
  const G = (a, b) => b === 0 ? a : G(b, a % b)
  const L = (a, b) => (a * b) / G(a, b)
  
  for(let i = 0; i < arr.length; i++){
      answer = L(answer, arr[i]);
  }
  
  return answer;
}