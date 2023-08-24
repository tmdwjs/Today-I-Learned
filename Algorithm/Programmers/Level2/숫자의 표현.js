// function solution(n) {
//     let answer = 0;
//     for(let i = 1; i <= n; i++){
//         let sum = 0;
//         for(let j = i; j <= n; j++){
//             sum += j;
//             if(sum == n) answer++;
//         }
//     }
//     return answer;
// }

function solution(n) {
  let answer = 0;
  let sum = 0;
  for(let i = 1; i <= n; i++){
      for(let j = i; j <= n; j++){
          sum += j;
          if(sum == n){
              answer++;
              sum = 0;
              break;
          }else if(sum > n){
              sum = 0;
              break;
          }
      }
  }
  return answer;
}