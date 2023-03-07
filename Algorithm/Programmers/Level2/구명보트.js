function solution(people, limit) {
  // 최대 인원 2
  // 즉 몸무게가 30 30 35라고 셋 태우는 경우는 없음
  // people 배열 2개 요소의 합 <= limit
  // 한 바퀴 돌면서 return 하면서 정답 카운트 + 1
  // 한 바퀴 돌면서 limit보다 크면 일단 한 명 나가는 건 확정이니까 정답 카운트 + 1
  // 아니면 정답 카운트 + 1 하면서, 둘 나가는 게 확정이니까 people.length - 1

  let answer = 0;
  let descWeight = people.sort((a, b) => b - a);
  // 무게가 많이 나가는 순으로 내림차순을 해야, 한 사람씩 탈 수 있는 사람들부터 구조 가능
  
  for(let i = 0, j = people.length - 1; i <= j; i++){
      // 혼자 탈출
      if(descWeight[i] + descWeight[j] > limit){
          answer += 1; // 한 명 탈출 했으니 카운트 + 1
      // 둘이 탈출
      }else {
          answer += 1; // 탈출했으니 카운트 + 1
          j -= 1; // 한 명 나갔으니 - 1
      }
  }
  
  return answer;
}