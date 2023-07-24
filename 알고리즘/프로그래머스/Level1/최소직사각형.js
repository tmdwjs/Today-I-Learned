function solution(sizes) {
  let answer = 0;
  
  for(let card of sizes){
      if(card[0] < card[1]) [card[0], card[1]] = [card[1], card[0]]
  }
  
  let w = Math.max(...sizes.map((card) => card[0]));
  let h = Math.max(...sizes.map((card) => card[1]));
  
  return answer = w * h;
}