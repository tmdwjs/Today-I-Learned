const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

const fibo = [0, 1];

for (let i = 2; i <= +input; i++) {
	fibo[i] = fibo[i-1] + fibo[i-2];
}

console.log(fibo[+input]);

// 10870 피보나치수 5
// n < 20