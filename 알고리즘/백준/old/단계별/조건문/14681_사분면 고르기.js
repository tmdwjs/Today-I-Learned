const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const [x,y] = input.map(v => +v);
let answer = 0;

if(x > 0 && y > 0) answer = 1;
if(x < 0 && y > 0) answer = 2;
if(x < 0 && y < 0) answer = 3;
if(x > 0 && y < 0) answer = 4;

console.log(answer);