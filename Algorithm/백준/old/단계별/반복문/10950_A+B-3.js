const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input[0];
const arr = input.slice(1).map(ab => ab.split(' ').map(v => +v));

for(let i = 0; i < n; i++){
  console.log(arr[i][0] + arr[i][1]);
}