// https://www.acmicpc.net/submit/17608

let input = require('fs')
.readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt')
.toString()
.trim()
.split('\n');

const n = +input.shift();
const arr = input.map(v => +v);
const stack = [];
let count = 1;
let isPoped = arr.pop();

for(let i = n-2; i >= 0; i--){
  if(arr[i] > isPoped) {
    isPoped = arr[i];
    count++;
  }
}

console.log(count);