// https://school.programmers.co.kr/learn/courses/30/lessons/42884

// routes[i][0] = 진입, routes[i][1] = 진출
// routes[[진입, 진출], [진입, 진출], ..., [진입, 진출]]]]

// 현재 차량의 진출 < 다음 차량의 진입 = 카메라 추가 설치

function solution(routes) {
  // 진입 기준으로 정렬
  // [[ -20, -15 ], [ -18, -13 ], [ -14, -5 ], [ -5, -3 ]]
  routes.sort((a, b) => a[0] - b[0]);
  
  let camera = 1; // 카메라는 최소 1대 설치
  let out = routes[0][1]; // -20

  // routes[0]과 routes[1]를 비교하기 위해 i = 1부터 시작.
  for(let i = 1; i < routes.length; i++){
    
    // 현재 진출보다 다음 진입이 크다 -> 공백이 생김 -> 카메라 추가 설치.
    if(out < routes[i][0]){
      camera++;
      out = routes[i][1] // 다음 진출을 out 변수에 재할당.
    }
    
    // 현재 진출이 다음 진입보다 크다 -> 카메라 추가 설치 X
    if(out > routes[i][1]){
      
      // 다음을 위해 다음 진출을 out 변수에 재할당.
      out = routes[i][1]
    }
  }

  return camera;
}