// https://school.programmers.co.kr/learn/courses/30/lessons/12938

function solution(n, s) {
  // 자연수 n의 합이 s보다 작을 리 없으므로,
  // 문제에서 요구한 대로, s < n 시 [-1] return.
  if(s < n) return [-1];

  // n = 2, s = 9, Math.floor(s / n) = 4
  const half = Math.floor(s / n);
  const answer = new Array(n).fill(half); // [4, 4]

  for(let i = 0; i < s % n; i++){
    // answer[2-1-0]++ = answer[1]++ = [4, 5]
    answer[answer.length - 1 - i] += 1;
    
    // 입출력 예 1~3번만 보면 마지막 나머지만큼 빼 줄 필요가 없어 보였는데,
    // 자연수 n의 개수가 2개만 들어오는 게 아니기 때문에 그런 것 같다.
  }

  return answer;
}