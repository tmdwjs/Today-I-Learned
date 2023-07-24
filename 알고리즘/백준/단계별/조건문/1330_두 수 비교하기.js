const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().split(' ');

const A = Number(input[0]);
const B = Number(input[1]);
let answer;

if(A > B){
  answer = '>'
}else if(A < B){
  answer ='<'
}else {
  answer = '=='
}

console.log(answer);