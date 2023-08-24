const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ');
const [n, r] = input.map(v => +v);
const diff = n - r;
const factorial = (num) => {
  let result = 1;

  for(let i = num; i >= 1; i--){
    result *= i;
  }

  return result
}

console.log(factorial(n) / (factorial(r) * factorial(diff)));