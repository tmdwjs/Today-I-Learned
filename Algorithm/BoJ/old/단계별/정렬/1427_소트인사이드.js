const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();
const arr = input.split('').map(v => +v).sort((a, b) => b - a);

console.log(arr.join(''));