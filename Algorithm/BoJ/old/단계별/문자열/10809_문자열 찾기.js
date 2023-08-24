const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

let answer = [];

for(let i = 97; i <= 122; i++){
  answer.push(input.indexOf(String.fromCharCode(i)));
}

console.log(answer.join(' '));