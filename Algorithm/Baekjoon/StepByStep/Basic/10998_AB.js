const input = require('fs').readFileSync(__dirname + '/input.txt').toString().split(' ');

const A = Number(input[0]);
const B = Number(input[1]);

console.log(A*B);