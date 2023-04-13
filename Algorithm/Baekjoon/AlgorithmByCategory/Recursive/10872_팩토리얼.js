const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

if(input === 0) return 1;

let answer = 1;

for(let i = input; i > 1; i--){
  answer *= i;
}

console.log(answer);

// 재귀는 자기 자신을 참조하는 것.
// for / while 등 적절히 사용하면 됨.