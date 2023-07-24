// 1 > 2 > 3번째 순으로 돌면 2번밖에 못 돌지만,
// 1 > 3 > 2번째 순으로 돌면 3번을 돌 수 있음.
// 단순하게 정렬 후 돌 게 아니라, 경우의 수를 다 찔러보는 게 맞는 것 같음. = 완전 탐색

function solution(k, dungeons) {
  let raid = new Array(dungeons.length).fill(0)
  let clear = 0
  
  function dfs(k, count){
      // 클리어 한 수와 카운트 한 수를 비교
      // 더 큰 수를 return 하도록 Math.max() 함수 사용
      clear = Math.max(count, clear)
      
      for (let i = 0; i < dungeons.length; i++){
          
          // 피로도 >= 최소 필요 피로도 && 레이드를 안 돌았다면
          // 즉, 레이드를 안 돈 던전이면서, 최소 피로도보다 피로도가 더 남은 상태라면,
          if (k >= dungeons[i][0] && !raid[i]){
              raid[i] = true // 확인
              // 피로도 - 소모 피로도, 카운트 + 1 후 재귀
              dfs(k - dungeons[i][1], count + 1)
              raid[i] = false // 피로도 깎고, 카운트 했으니 다시 false로
          }
      }
  }

  dfs(k, 0);

  return clear;
}