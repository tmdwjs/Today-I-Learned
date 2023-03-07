// https://school.programmers.co.kr/learn/courses/30/lessons/42747

function solution(citations) {
  let answer = 0;
  
  // 많이 인용된 순으로 정렬 -> 내림차순
  // [6, 5, 3, 1, 0]
  citations.sort((a, b) => b - a);

  for(let i = 0; i < citations.length; i++){
    if(i < citations[i]) answer++;
  }

  return answer;
}