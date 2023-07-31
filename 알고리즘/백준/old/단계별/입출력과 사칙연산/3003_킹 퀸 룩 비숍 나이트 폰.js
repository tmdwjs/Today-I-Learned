const input = require('fs').readFileSync(__dirname + '/input.txt').toString().split(' ');

// const arr = [];
// const num = input.map(v => Number(v))
// const chess = [1, 1, 2, 2, 2, 8];

// for(let i = 0; i < chess.length; i++){
//   arr.push(chess[i] - num[i]);
// }

const a = 1-Number(input[0]);
const b = 1-Number(input[1]);
const c = 2-Number(input[2]);
const d = 2-Number(input[3]);
const e = 2-Number(input[4]);
const f = 8-Number(input[5]);

console.log(a, b, c, d, e, f);