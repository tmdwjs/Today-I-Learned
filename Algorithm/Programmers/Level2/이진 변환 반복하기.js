function solution(s) {
  // return [반복 횟수, 제거된 0 개수]
  // let loopCount
  // let removeCount
  // return [loopCount, removeCount]
  
  // 받아온 s가 1이 아닐 때 진행되어야 함
  // while(s !== 1){
      // filter 함수를 통해 1만 남기고
      // s.length와 나온 걸 비교해서 removeCount++???
      // 반복문 나가기 전에 loopCount + 1
  // }
  
  let loopCount = 0;
  let removeCount = 0;
  
  while(s !== '1'){
    let removeZero = [...s].reduce((acc, cur) => {
      if(cur == '0') {
        removeCount += 1;
        return acc;
      }
      return acc + 1;
    }, 0)
    
    s = removeZero.toString(2);
    loopCount += 1;
  }
  
  return [loopCount, removeCount];
}