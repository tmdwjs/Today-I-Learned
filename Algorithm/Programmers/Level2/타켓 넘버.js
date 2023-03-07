// https://school.programmers.co.kr/learn/courses/30/lessons/43165

function solution(numbers, target) {
  // numbers.length만큼 반복문 돌면서 더하거나 빼야 한다.
  // numbers를 다 소진한 상태에서(or numbers.length와 같아지는 지점) target과 같으면 answer ++;
  
  let answer = 0; // target과 같아질 때마다 정답을 계속 카운트 한다.
  dfs(0, 0);
  
  function dfs(depth, acc) {
      if(depth < numbers.length){
          dfs(depth + 1, acc + numbers[depth]);
          dfs(depth + 1, acc - numbers[depth]);
      }else {
          if(acc === target) answer ++;
      }
  }
  
  return answer;
}