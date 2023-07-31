const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');
const n = +input[0];
const arr = input[1].split(' ').map(v => +v);
let answer = 0;

const isPrime = (n) => {
  if(n === 1) return false;
  for(let i = 2; i <= Math.sqrt(n); i++){
    if(n % i === 0) return false;
  }
  return true;
}

for(let i = 0; i < n; i++){
  if(isPrime(arr[i])) answer++;
}

console.log(answer);