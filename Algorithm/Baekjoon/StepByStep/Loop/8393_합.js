const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

let answer = 0;

for(let i = 0; i < input; i++) answer += input - i

console.log(answer);