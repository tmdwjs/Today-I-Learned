const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input[0];
const ab = input.slice(1).map(v=> v.split(' ').map(elem => +elem));
let answer = '';

for(let i = 0; i < n; i++) {
  answer += ab[i][0] + ab[i][1] + '\n';
}

console.log(answer);