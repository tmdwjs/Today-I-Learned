const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ');
const [n, m] = input.map(v => +v);

const answer = [];

const G = (a, b) => b === 0 ? a : G(b, a % b)
const L = (a, b) => (a * b) / G(a, b)

answer.push(G(n, m), L(n, m));

console.log(answer.join('\n'));