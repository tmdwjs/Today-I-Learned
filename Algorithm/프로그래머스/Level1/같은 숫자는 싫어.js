function solution(arr){
  let answer = []; // 담아서 리턴할 빈 배열
  
  for(let i = 0; i < arr.length; i++) {
      if(arr[i] !== arr[i+1]) answer.push(arr[i]);
  }
  
  return answer;
}