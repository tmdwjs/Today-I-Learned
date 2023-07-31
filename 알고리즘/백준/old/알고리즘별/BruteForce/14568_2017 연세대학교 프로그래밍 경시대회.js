// https://www.acmicpc.net/problem/14568

let input = require('fs')
.readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt')
.toString()
.trim();

input = +input;

for(let i = 1; i < Math.sqrt(10101); i++){
  if(1 + i + i*i === input) console.log(i);
}