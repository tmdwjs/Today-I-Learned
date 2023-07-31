const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const len = input.shift();
const arr = input.map(v => Number(v)).sort((a, b) => a - b);

for(let i = 0; i < len; i++){
  console.log(arr[i]);
}