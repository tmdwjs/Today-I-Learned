function solution(s){
  let str = s.toLowerCase();
  let num = 0;
  
  for(let i = 0; i <= str.length; i++){
      if(str[i] == 'p'){
          num++;
      }else if(str[i] == 'y'){
          num--;
      }
  }
  return num == 0 ? true : false
}