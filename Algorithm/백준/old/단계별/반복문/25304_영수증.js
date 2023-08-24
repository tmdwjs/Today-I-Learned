const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const total = +input[0];
const quantity = +input[1];
const receipt = input.slice(2).map(item => item.split(' ').map(v => +v));
let calc = 0;

for(let i = 0; i < quantity; i++) calc += receipt[i][0] * receipt[i][1];

console.log(calc === total ? 'Yes' : 'No');