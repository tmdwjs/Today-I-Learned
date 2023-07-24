function solution(s, n) {
  return s.split('').map((value) => {
      if(value == ' ') return ' ';
      let code = value.charCodeAt(0);
      if(code <= 90 && code + n > 90 || code + n > 122){
          return String.fromCodePoint(code + n - 26)
      }else{
          return String.fromCodePoint(code + n)
      }
  })
  .join('');
}