const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

let fibo = [0, 1];

for (let i = 2; i <= +input; i++) {
	fibo[i] = BigInt(fibo[i-1]) + BigInt(fibo[i-2]);
}

console.log(fibo[+input].toString());

// 10870, 2747과 다른 점
// n < 90

// 이처럼 수가 엄청나게 커 지면 BigInt 내장함수를 사용
// 단 출력 시 toString()을 사용해 숫자형태로 출력한다.