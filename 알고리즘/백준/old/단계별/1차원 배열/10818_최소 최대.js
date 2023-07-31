const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = input[0].split(' ').map(v => +v);
const arr = input[1].split(' ').map(v => +v);
arr.sort((a, b) => a - b);
const min = arr[0];
const max = arr[arr.length-1];

console.log(min, max);