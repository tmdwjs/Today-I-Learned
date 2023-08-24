const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const arr = input.slice(' ').map(v => +v);
let max = arr[0];
let maxIdx = 0;

for(let i = 1; i < 9; i++){
  if(max < arr[i]) {
    max = arr[i];
    maxIdx = i;
  }
}

console.log(max);
console.log(maxIdx+1);