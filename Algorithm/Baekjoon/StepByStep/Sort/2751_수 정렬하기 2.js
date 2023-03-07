const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

console.log(input.slice(1).map(v => +v).sort((a, b) => a - b).join('\n'))

// 중복 제거까지 하느냐 시간 초과가 떴다.
// 5 5 4 3 2 1 이런 식으로 들어와서 5 5를 중복 제거까지 하는 줄 앎..
// 배열의 개수였고, 시간 초과 없이 다시 풀었다.