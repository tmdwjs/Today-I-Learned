const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');
const n = +input[0];
const arr = input[1].split('');

let hash = 0;

for(let i = 0; i < n; i++){
  hash += (arr[i].charCodeAt() - 96) * (31 ** i);
  hash %= 1234567891;
}

console.log(hash);