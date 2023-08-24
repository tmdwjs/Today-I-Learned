const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();
let answer = '';

for(let i = 1; i <= input; i++){
  answer += i + '\n';
}

console.log(answer);