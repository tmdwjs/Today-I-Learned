// 1
function solution(s) {
  return s.split('').sort((a, b) => {
      if(a > b) return -1;
      if(a < b) return 1;
  }).join('');
}

// 2
function solution(s) {
  return s.split('').sort().reverse().join('');
}