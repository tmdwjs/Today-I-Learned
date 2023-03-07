const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const nx = input[0].split(' ').map(v => +v);
const n = nx[0];
const x = nx[1];
const arr = input[1].split(' ').map(v => +v);
let answer = '';

for(let i = 0; i < n; i++){
  if(arr[i] < x) answer += arr[i] + ' ';
}

console.log(answer);