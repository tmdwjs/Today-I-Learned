function solution(a, b) {
  var answer = 0;
  for(key in a){
      answer += a[key] * b[key];
  }
  return answer;
}