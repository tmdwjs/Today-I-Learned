const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const [n, k] = input[0].split(' ').map(v => +v);
const arr = input[1].split(' ').map(v => +v).sort((a, b) => b - a);

console.log(arr[k-1]);