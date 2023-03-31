const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input;

for(let i = 1; i <= n; i++) console.log('*'.repeat(i));