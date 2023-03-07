// https://school.programmers.co.kr/learn/courses/30/lessons/43163

function solution(begin, target, words) {
  let answer = 0;
  let arr = [];
  let visited = [];
  
  // words에 target 없으면 0 return.
  if(!words.includes(target)) return 0;

  // 배열에 [시작 단어, 변환 횟수] push.
  arr.push([begin, answer]); // [['hit', 0]]

  while(arr){
    let [now, cnt] = arr.shift(); // 기존 맨 앞 배열 삭제하고 할당하여,
    // 현재 단어와 target이 맞다면, 직전까지 카운트 한 cnt return.
    if(now === target) return cnt; 

    // words 요소를 돌면서 비교
    words.forEach(word => {
      let diff = 0; // words의 요소들과 비교 후 다른 만큼 카운트.
      if(visited.includes(word)) return; // 비교했었던 단어면 패스.

      // 반복문을 돌며, 단어가 다를 때마다 카운트 하고,
      for(let i = 0; i < word.length; i++){
        if(word[i] !== now[i]) diff++;
      }

      // 다른 게 한 개일 시,
      if(diff === 1){
        arr.push([word, ++cnt]); // 배열에 [해당 단어, 변환 횟수 +1]을 push.
        visited.push(word); // 비교했던 대상으로 분류.
      }
    })
  }

  return answer;
}