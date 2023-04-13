const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

let answer = 'F';

if(input >= 90) answer = 'A';
if(input >= 80 && input <= 89) answer = 'B';
if(input >= 70 && input <= 79) answer = 'C';
if(input >= 60 && input <= 69) answer = 'D';

console.log(answer);