const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const arr = input.slice(1).map(man => man.split(' ')).sort((a, b) => a[0] - b[0]).map(v => v.join(' ')).join('\n');

console.log(arr);