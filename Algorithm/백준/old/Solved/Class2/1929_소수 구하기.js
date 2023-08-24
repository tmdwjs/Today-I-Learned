// https://www.acmicpc.net/problem/1929

const input = require('fs')
.readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt')
.toString()
.trim()
.split(' ');

const [n, m] = input.map(v => +v);
const answer = [];

const isPrime = (n) => {
  if(n === 1) return false;

  for(let i = 2; i <= Math.sqrt(n); i++){
    if(n % i === 0) return false;
  }

  return true;
}

for(let i = n; i <= m; i++){
  if(isPrime(i)) answer.push(i);
}

console.log(answer.join('\n'));