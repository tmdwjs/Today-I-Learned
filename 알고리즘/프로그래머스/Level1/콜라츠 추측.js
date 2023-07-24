function solution(num) {
    
  for(let i = 0; i < 500; i++) { // 500번 돌기
      if (num !== 1) {
          num = num % 2 == 0 ? num / 2 : num * 3 + 1
      } else {
          return i
      }
  }
  return -1;
}