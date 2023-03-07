const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

console.log(input.slice(1).map(v => +v).sort((a, b) => a - b).join('\n'))

// node.js 메모리 초과로 인해 python 코드 복붙