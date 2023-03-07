const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const arr = input.slice(1).map(v => v.split(' ').map(el => + el));

arr.sort((a, b) => {
  return a[1] !== b[1] ? a[1] - b[1] : a[0] - b[0];
})

const answer = arr.map(v => v.join(' ')).join('\n')

console.log(answer);