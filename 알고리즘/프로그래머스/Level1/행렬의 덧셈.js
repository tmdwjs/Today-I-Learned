function solution(arr1, arr2) {
  let answer = [];
  
  for(let i = 0; i < arr1.length; i++){ // [1, 2] [2, 3]
      let sum = [];

      for(let j = 0; j < arr1[i].length; j++){ // arr1 배열 길이만큼 돌리기
          sum.push(arr1[i][j] + arr2[i][j]); // [1, 2] [3, 4] / [2, 3] [5, 6] 
      }
          answer.push(sum); // [[4, 6], [7, 9]]
      }
  
  return answer;
}