const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = input.map(ab => ab.split(' ').map(v => +v));

for(let i = 0; i < n.length-1; i++) console.log(n[i][0] + n[i][1]);