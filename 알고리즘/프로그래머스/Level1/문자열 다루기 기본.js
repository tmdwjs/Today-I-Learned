function solution(s) {
    
  if (s.length === 4 || s.length === 6) { // 길이가 4 혹은 6이면 반복문
      return s.split('').every(a => !isNaN(a)); // 모두 숫자일 땐 여기서 true로
  }
  
  return false; // 길이 4 혹은 6 이외는 전부 false
}