function solution(d, budget) {
    
  let answer = 0; // 팀 수
  let sum = 0; // 신청금 합
  
  d.sort((a, b) => a - b) // 오름차순 정렬
  
  for (let i = 0; i < d.length; i++) {
      answer ++; // 팀 수 카운트
      sum += d[i]; // 신청금 카운트
      
      // 합이 예산보다 작으면 직전 한 팀 제외
      if (sum > budget) answer--;
  }
  
  return answer;
}