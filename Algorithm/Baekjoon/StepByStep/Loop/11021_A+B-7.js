const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input[0];
const arr = input.slice(1).map(ab => ab.split(' ').map(v => +v));

for(let i = 1; i <= n; i++){
  console.log('Case #' + i + ':', arr[i-1][0] + arr[i-1][1]);
}