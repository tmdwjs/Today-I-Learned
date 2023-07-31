const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().split('\n');

const K = Number(input.shift());
const stack = [];
const arr = input.map(v => Number(v));

for(let i = 0; i < K; i++){
  if(arr[i] === 0) stack.pop();
  if(arr[i] !== 0) stack.push(arr[i]);
}

const answer = stack.reduce((acc, cur) => acc + cur, 0);

console.log(answer);

// 스택의 경우 반복문을 돌면서 빈 배열에 담는 게 포인트
// 특정 조건에서 shift or pop을 사용해 배열의 첫 번째 요소나 마지막 요소를 지워주는 형식이다.
// 물론 가장 베이스가 되는 풀이일 뿐, 난이도에 따라 응용력은 필수..