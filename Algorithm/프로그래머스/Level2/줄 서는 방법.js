// n=3, [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
// 2번마다 배열의 첫 번째가 바뀌는 것을 확인할 수 있다. 즉, n-1의 팩토리얼마다 바뀜

// n=3, k=2 ? 배열의 첫 번째 1로 시작 k/n-1 > [1,-,-]
// n=3, k=4 ? 배열의 첫 번째 2로 시작 k/n-1 > [2,-,-]
// n=3, k=6 ? 배열의 첫 번째 3로 시작 k/n-1 > [3,-,-]
// 즉 k/n-1을 통해 배열의 첫 번째를 구할 수 있다.
// 단, 배열인 만큼 k-1/n-1으로 구하기.

function solution(n, k) {
  let answer = [];
  // [1, 2, 3, ..., n] 형태의 배열 생성
  let arr = new Array(n).fill(1);
  for(let i = 1; i < n; i++) arr[i] = arr[i-1] + 1
  let idxK = k-1; // 실제 k번째는 배열 인덱스에서는 -1 위치
  
  while(arr.length){
    // 나머지가 0일 때
    if(idxK === 0){
        answer.push(...arr);
        break;
    }
    
    let fact = factorial(arr.length - 1); // 받아온 n - 1의 팩토리얼
    let idx = Math.floor(idxK / fact) // 소수점 버림, 정수 반환
    
    idxK = idxK % fact
    
    answer.push(arr[idx]);
    arr.splice(idx, 1);
  }
  
  return answer;
}

function factorial(n){
  let res = 1;
  for(let i = 2; i <= n; i++) res *= i;
  return res;
}