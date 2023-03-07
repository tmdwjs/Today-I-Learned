// https://school.programmers.co.kr/learn/courses/30/lessons/12971

// 가장 큰 수를 떼는 게 중요한 게 아니라,
// 큰 수를 뗌으로써 마지막과 두 번째가 나가리 되면 의미 없음.

// 첫 번째 선택 시 마지막 선택 못함
// 첫 번째 선택 안 할 시, 마지막 선택 가능
// 첫 번째 선택 or 두 번째 선택
// 두 개 경우의 수를 다 돌려보고, 더 큰 수를 return.

// 일단 초기화를 한다. 0에서부터 시작해 더해야 하니까
// 현재 = 직전 vs 2번째 전 + 현재
// i = i - 1 vs i - 2 + sticker[i]
// 첫 번째 선택 시 i - 2가 음수가 되면 안 되니 sticker의 length에 +2만큼 해 주기.

function solution(sticker) {
  const size = sticker.length+2;
  const dp1 = new Array(size).fill(0);
  const dp2 = new Array(size).fill(0);

  // early return
  // sticker가 한 장인 경우 해당 스티커 숫자를 return
  if(sticker.length === 1) return sticker[0];
  
  // 첫 번째 스티커를 뜯었을 시.
  // 마지막은 뜯지 못 하므로 size-1만큼 반복문을 돌린다.
  for(let i = 2; i < size-1; i++){
      dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i-2])
  }
  
  // 두 번째 스티커를 뜯었을 시.
  for(let i = 3; i < size; i++){
      dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i-2])
  }
  
  // return 더 큰 수(첫 번째 스티커 뜯은 경우, 두 번째 스티커 뜯은 경우)
  return Math.max(dp1[size-2], dp2[size-1]);
}