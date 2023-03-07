function solution(number, k) {
  let answer = [];
  
  for(let i = 0; i < number.length; i++){
    // 직전에 입력된 요소와 현재 요소와 비교 후 더 큰 요소 입력
    while(k > 0 && answer[answer.length-1] < number[i]){
      k--; // k 감소
      answer.pop(); // 작은 요소 제거
    }
    
    answer.push(number[i]);
  }

  // k를 다 사용하지 못한 경우, k만큼 요소를 제거
  answer.splice(answer.length-k, k);
  return answer.join('');
}