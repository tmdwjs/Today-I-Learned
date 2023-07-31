const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');
const [n, ...arr] = input;

let isNotAns = 0; // 연속된 문자가 아닌 것

for(let i = 0; i < n; i++){
  let word = arr[i]; // 단어들
  let checker = Array(26).fill(0); // 나왔는지 아닌지 체크할 배열 생성

  // 현재와 다음을 비교해야 하니, 단어의 길이보다 1만큼 작게 반복문
  for(let j = 0; j < word.length - 1; j++){
    const cur = word[j];
    const next = word[j+1];

    // 다른 것만 판단할 거니 일단 같으면 스킵
    if(cur === next) continue;
    else {
      if(checker[next.charCodeAt(0) - 97]){
        isNotAns++;
        break;
      }
    }

    // 디폴트로, 현재 문자의 맞는 체커 배열을 1로 변경
    checker[cur.charCodeAt(0) - 97] = 1;
  }
}

console.log(n - isNotAns);