let input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ');

const [N, K] = input.map(v => +v);
let answer = [];

for(let i = 1; i <= N; i++){
  if(N % i === 0) answer.push(i);
}

console.log(answer[K-1] || 0);