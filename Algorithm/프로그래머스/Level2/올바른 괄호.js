function solution(s){
  let answer = 0;
  
  for(let i = 0; i < s.length; i++){
      if(s[i] == '(') answer += 1;
      if(s[i] == ')') answer -= 1;
      if(answer < 0) return false;
  }
  return answer == 0 ? true : false;
}