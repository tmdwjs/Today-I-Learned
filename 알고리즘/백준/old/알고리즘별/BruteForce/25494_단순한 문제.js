let input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input.shift();
const arr = input.map(v => v.split(' ').map(el => +el));

for(let i = 0; i < n; i++){
  console.log(Math.min(...arr[i]));
}

console.log('Math.min(arr[0]): ', Math.min(...arr[0]));

// a 나누기 b의 나머지
// b 나누기 c의 나머지
// c 나누기 a의 나머지
// 이 셋의 나머지가 같으려면 전부 같은 숫자여야 한다.

// 1보다 세 개의 자연수 중에서, a = b = c가 같으려면,
// 1부터 세 개의 자연수 중 가장 같은 수까지는 전부 해당됨

// 1, 2, 3
// 2, 3은 안됨, 1만 됨.
// 1 나누기 1, 1 나누기 1, 1 나누기 1 > 조건 성립

// 3, 2, 4 = 2, 3, 4
// 2 때문에 3하고 4는 안 됨.
// 1 이상 2 이하는 1과 2
// 1 나누기 1, 1 나누기 1, 1 나누기 1
// 2 나누기 2, 2 나누기 2, 2 나누기 2
// 조건 성립되는 쌍 2 쌍

// 규칙이 보임
// 세 개의 자연수 중 가장 같은 숫자가 정답