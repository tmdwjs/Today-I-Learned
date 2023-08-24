const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input.shift();
const arr = input[0].split(' ').map(v => +v);
const setArr = new Set(arr);
const sortArr = [...setArr].sort((a, b) => a - b);

const obj = {};
sortArr.forEach((v, i) => obj[v] = i);

let answer = '';
for(let i = 0; i < n; i++){
  answer += obj[arr[i]] + ' ';
}
console.log(answer);