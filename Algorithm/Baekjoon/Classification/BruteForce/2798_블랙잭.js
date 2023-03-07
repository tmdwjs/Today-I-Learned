const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const NM = input[0].split(' ').map(v => Number(v));
const N = NM.shift();
const M = NM.shift();
const card = input[1].split(' ').map(v => Number(v)).sort((a, b) => b - a);
let max = 0;

for(let i = 0; i < N - 2; i++){
  for(let j = i + 1; j < N - 1; j++){
    for(let k = j + 1; k < N; k++){
      let sum = card[i] + card[j] + card[k]
      if(max <= sum && sum <= M) max = sum;
    }
  }
}

console.log(max);

// 완전탐색이면서 3장 고르라 하면 웬만하면 for문 중첩하는 게 제일 심플한 듯?