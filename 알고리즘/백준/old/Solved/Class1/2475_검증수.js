const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ');

const n = input.map(v => +v);
let sum = 0;

for(let i = 0; i < n.length; i++){
  sum += n[i] * n[i];
}
console.log(sum % 10);