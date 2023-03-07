const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();
let answer = '';

for(let i = input; i >= 1; i--){
  answer += i + '\n';
}

console.log(answer);