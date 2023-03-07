function solution(n, words) {
  let turn = 1; // return 할 turn

  for(let i = 1; i < words.length; i++){
    
    // 아래 두 조건이 둘 다 충족되어야 패스할 수 있다.
    // 1. 현재 단어의 맨 앞이 직전 단어의 끝과 같아야 한다.
    // 2. 처음부터 지금까지의 단어 중, 현재 단어가 포함되어 있지 않아야 한다.
    let pass = (words[i][0] == words[i-1][words[i-1].length-1]) 
    && !(words.slice(0, i).includes(words[i]));
  
    // 반복 수 / 인원 수가 나눠 떨어지면? 한 바퀴의 turn이 이루어짐.
    if(i % n === 0) turn ++; // turn +1
    // 패스 조건을 충족하지 못한 순간, [현재 그 사람의 번호, 차례]
    if(!pass) return [i % n + 1, turn];
  }

  // 탈락자가 없다면 [0, 0] return
  return [0, 0];
}