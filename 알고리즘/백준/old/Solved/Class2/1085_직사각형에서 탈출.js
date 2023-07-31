const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ');

const [x, y, w, h] = input.map(v => +v);
const arr = [x, y, w - x, h - y];
arr.sort((a, b) => a - b);

console.log (arr[0]);