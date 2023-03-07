const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

let num = +input;
let cnt = 0;
let sum;

while(true){
  cnt++;
  sum = Math.floor(num / 10) + num % 10;
  num = ((num % 10) * 10) + (sum % 10);

  if(num === +input) break;
}

console.log(cnt);

// split 등으로 일의 자리와 십의 자리를 자르고,
// toString으로 문자열 바꾸고 더하고 다시 숫자로 변환하는 등 너무 복잡하게 생각했다.

// 일의 자리에 있는 수 구하기: num % 10
// 십의 자리에 있는 수 구하기: Math.floor(num / 10)
// 일의 자리에 있는 수 10의 자리 수로 만들기 : (num % 10) * 10

// 위 공식만 있으면 우리가 필요한, 일의 자리 + 십의 자리를 구할 수 있고,
// 1 + 1이 2가 아닌 11로 출력하는 것도 가능해진다.
// e.g. (1 % 10 * 10) = 10 + (1 % 10) = 1 = 11