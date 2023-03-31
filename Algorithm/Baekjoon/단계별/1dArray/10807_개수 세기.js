const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().split('\n');

let answer = 0;

input[1].split(' ').forEach(elem => {
  if(elem === input[2]) answer++;
});

console.log(answer);