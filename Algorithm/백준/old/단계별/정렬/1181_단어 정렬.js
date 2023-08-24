const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

let arr = new Set(input.slice(1));
arr = [...arr];

const sort = arr.sort((a, b) => a.length - b.length || a.localeCompare(b));

console.log(sort.join('\n'));

// charCodeAt()을 사용해서 문자열을 정수로 변환하여 계산이 가능하지만
// localeCompare도 가능