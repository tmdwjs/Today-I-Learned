const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().split('\n');

const A = Number(input[0]);
const B = Number(input[1]);
const B1 = Number(input[1].split('')[2]);
const B2 = Number(input[1].split('')[1]);
const B3 = Number(input[1].split('')[0]);

console.log(A*B1);
console.log(A*B2);
console.log(A*B3);
console.log(A*B);