// https://www.acmicpc.net/problem/2605

let input = require('fs')
.readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt')
.toString()
.trim()
.split('\n');

const n = +input.shift();
const arr = input[0].split(' ').map(v => +v);
const answer = [];

for(let i = 0; i < n; i++){
  answer.splice(i - arr[i], 0, i+1);
}

console.log(answer.join(' '));