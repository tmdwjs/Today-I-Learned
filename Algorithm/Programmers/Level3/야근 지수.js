// https://school.programmers.co.kr/learn/courses/30/lessons/12927

// 1. n만큼 반복을 돌아 n을 전부 소진.
// 		1) 야근 지수 = 남은 작업량의 제곱.
//		2) 즉, 내림차순으로 정렬 후 가장 큰 수와 비교하여 처리한다.
// 2. 최종 배열을 가지고 야근 지수 구하기.
// 		1) reduce 함수를 사용하여 누적하여 return.
//		2) works의 요소의 합이 n보다 작거나 같으면 return 0.

function solution(n, works){
  // 2-2) 우선적으로, works의 요소의 합이 n보다 작거나 같으니 return 0.
  if(works.reduce((a, b) => a + b) <= n) return 0;

  // 내림차순(오름차순으로 해도 상관 없다.)
  works.sort((a, b) => b - a);

  while(n){
    // 가장 큰 수를 변수에 할당해, 큰 수를 우선적으로 처리한다.
    const max = works[0];

    for(let i = 0; i < works.length; i++){
      if(works[i] >= max){
        works[i]--;
        n--;
      }

      if(!n) break; // n 전부 소진 시 break.
    }
  }
  
  return works.reduce((a, b) => a + Math.pow(b, 2), 0);
}