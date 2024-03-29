# 프로그래머스 

## 문제

[다리를 지나는 트럭(자바스크립트/레벨 2)](https://school.programmers.co.kr/learn/courses/30/lessons/42583)

## 코드

```js
function solution(bridge_length, weight, truck_weights) {
  var answer = 0;
  let bridge = Array.from({length: bridge_length}, v => 0);
  let bridge_weigths = 0; // 트럭 한 대가 올라갈 때마다 더하여 할당할 변수

  answer++; // 1초 증가
  bridge.shift(); // 다리 위 맨 앞 트럭 shift()
  bridge_weigths += truck_weights[0]; // 맨 앞(올라갈) 트럭 무게 더하기
  bridge.push(truck_weights.shift()); // 트럭 다리 위에 추가

  // 트럭이 올라갔을 때(bridge_weigths가 양수) 반복문 실행
  while(bridge_weigths){
    answer++; // 시간 카운트
    bridge_weigths -= bridge.shift(); // 직전에 올라간 트럭 내림

    // 만약 다리가 트럭 무게를 버틸 만하면,
    if(bridge_weigths + truck_weights[0] <= weight){
      bridge_weigths += truck_weights[0];
      bridge.push(truck_weights.shift());
    }else {
      bridge.push(0);
    }
  }

  return answer;
}
```

# 백준

<img width="600" alt="image" src="https://user-images.githubusercontent.com/85447054/198820693-a967c35c-eb9b-4922-9040-3998636ca7e7.png">

예전에 너무 무지성으로 프로그래머스를 푼 탓에(푸는 데에만 초첨을 둬), 다시 기초부터 쌓고 싶어서 백준도 병행하고 있습니다. 자바스크립트로 풀이하시는 분들이라면 아시겠지만 백준 환경에서 정말 까다로운 게 많아 계속 미뤘는데, 오늘 환경 세팅부터 다시 해 완전 처음으로 돌아가 다시 해 보자는 마인드로 단계 별 풀이로 진행 중에 있습니다.