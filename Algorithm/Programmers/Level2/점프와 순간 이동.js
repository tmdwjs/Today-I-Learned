// https://school.programmers.co.kr/learn/courses/30/lessons/12980

// 최소한의 1을 더하고 2를 곱해서 장소 n에 도착한 거라면,
// 장소 n을 2로 나누고 안 나눠질 때마다 1을 빼면 최소한의 사용량을 구할 수 있다.

function solution(n){
  let battery = 1; // 시작점이 0이라 무조건 1은 더하고 시작한 상태.

  while(n > 1){
    if(n % 2 === 0){ 	// 나눠지면,
      n = n / 2 		// 계속 나누고,
    }else { 			// 안 나눠지면,
      n = (n - 1) / 2 	// 1만큼 빼 주고,
      battery++; 		// 건전지 사용량을 1만큼 더해준다.
    }
  }

  return battery;
}