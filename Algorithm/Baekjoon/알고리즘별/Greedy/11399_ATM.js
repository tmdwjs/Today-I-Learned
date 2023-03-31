const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().split('\n');

// 그리디는 최댓값 or 최솟값 구할 때 사용하는 것. > 지금은 최솟값 구하라고 하네
// 근데 지금처럼 누적되는 최솟값의 경우 오름차순 후 하면 되지 않나..

const N = Number(input.shift());
const min = input[0].split(' ').map(v => Number(v)).sort((a, b) => a - b).reduce((acc, cur, i) => acc + cur * (N - i), 0);

console.log(min);