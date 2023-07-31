const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const arr = input.map(v => +v);
const mod = [];
let answer = [];

for(let i = 0; i < arr.length; i++){
  mod.push(arr[i] % 42);
}

mod.forEach(v => {
  if(!answer.includes(v)) answer.push(v)
})
console.log(answer.length);