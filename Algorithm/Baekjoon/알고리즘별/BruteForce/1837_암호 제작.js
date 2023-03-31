// 시간 초과
// let input = require('fs')
// .readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt')
// .toString()
// .trim();

// const [M, K] = input.split(' ').map(v => +v);

// const isPrime = (n) => {
//   if(n === 1) return false;

//   for(let i = 2; i <= Math.sqrt(n); i++){
//     if(n % i === 0) return false;
//   }

//   return true;
// }

// for(let i = 1; i <= M; i++){
//   if(isPrime(i)) {
//     if(M % i === 0 && i < K) {
//       console.log(`BAD ${i}`);
//       process.exit();
//     }
//   }
// }

// console.log('GOOD');

// 잘못된 코드인 이유 1
// 소수 * 소수이기 때문에, 나눠 떨어지는 순간 어차피 소수와 소수만 남게 됨.
// 즉 소수를 판별하는 함수를 만들어 확인할 필요가 없음

// 잘못된 코드인 이유 2
// 소수 * 소수까지 반복문을 돌며,
// 제한된 숫자를 넘나 안 넘나 판단하는 게 아닌,
// 제한된 숫자까지 반복문을 돌아, 그 안에 나눠떨어지지 않으면 
// 두 소수의 곱은 자연스럽게 GOOD으로 출력될 수밖에 없음
// 그 안에 나눠떨어지는 수가 있으면 바로 return
// 하지만 두 개 중 가장 작은 수를 return 해야 하기 때문에,
// 배열에 담아 배열의 첫 번째를 return 하는 게 아닌,
// process.exit() 메서드를 사용해 바로 종료(가장 먼저 나오는 게 가장 작은 숫자일 테니)

// 잘못된 코드인 이유 3
// 시간 초과를 막기 위해 엄청나게 큰 수가 들어올 수 있음
// 이를 위해 BigInt 메서드를 사용

let input = require('fs')
.readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt')
.toString()
.trim();

const [M, K] = input.split(' ').map(v => BigInt(v));

for(let i = BigInt(2); i < K; i++){
  if(M % i === BigInt(0)) {
    console.log(`BAD ${i}`);
    process.exit();
  }
}

console.log('GOOD');