const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input[0];
const arr = input[1].split(' ').map(v => +v);
const max = Math.max(...arr);
let sum = 0;

for(let i = 0; i < n; i++){
  sum += arr[i] / max * 100;
}

console.log(sum / n);