// https://school.programmers.co.kr/learn/courses/30/lessons/42583

function solution(bridge_length, weight, truck_weights) {
  let answer = 0;
  let bridge = Array.from({length: bridge_length}, v => 0);
  let bridge_weigths = 0;
  
  answer++;
  bridge.shift();
  bridge_weigths += truck_weights[0];
  bridge.push(truck_weights.shift());
  
  while(bridge_weigths){
      answer++;
      bridge_weigths -= bridge.shift();

      if(bridge_weigths + truck_weights[0] <= weight){
          bridge_weigths += truck_weights[0];
          bridge.push(truck_weights.shift());
      }else {
          bridge.push(0);
      }
  }
  
  return answer;
}