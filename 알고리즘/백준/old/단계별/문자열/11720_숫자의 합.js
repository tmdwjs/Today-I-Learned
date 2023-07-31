const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const answer = input[1].split('').map(v => +v).reduce((acc, cur) => acc + cur, 0);

console.log(answer);