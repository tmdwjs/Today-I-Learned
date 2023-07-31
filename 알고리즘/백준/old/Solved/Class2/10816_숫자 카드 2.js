const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input[0];
const m = +input[2];
const nArr = input[1].split(' ').map(v => +v);
const mArr = input[3].split(' ').map(v => +v);
const map = new Map();
let answer = [];

nArr.forEach(v => {
  if(map.has(v)) map.set(v, map.get(v) + 1)
  else map.set(v, 1)
})

mArr.forEach(v => {
  answer.push(map.get(v) || 0)
})

console.log(answer.join(' '));