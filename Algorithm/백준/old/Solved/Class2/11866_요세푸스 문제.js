const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ');

// 1 2 3 4 5 6 7 > 3번째 제거 > 3
// 4 5 6 7 1 2 > 3번째 제거 > 3 6
// 7 1 2 4 5 > 3번째 제거 > 3 6 2
// 4 5 7 1 ...

const [n, k] = input.map(v => +v);
const arr = Array.from({length: n}, (v, i) => i + 1);
const answer = [];

for(let i = 0; i < n; i++){
  for(let j = 1; j <= k; j++){
    if(j === k) answer.push(arr.shift());
    else arr.push(arr.shift())
  }
}

console.log(`<${answer.join(', ')}>`);