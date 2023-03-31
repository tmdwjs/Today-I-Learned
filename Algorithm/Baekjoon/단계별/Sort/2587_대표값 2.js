const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const sort = input.map(v => +v).sort((a, b) => a - b);

const len = sort.length;
const hLen = Math.floor(sort.length/2);
const avg = sort.reduce((acc, cur) => {return Math.floor((acc + cur) / len)}, 0);
const mid = sort[hLen];

console.log(sort.reduce((acc, cur) => Math.floor((acc + cur)), 0)/len);
console.log(mid);