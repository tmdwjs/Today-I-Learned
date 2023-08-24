const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

// 1 1 1     3 3 3
// 2 2 2     4 4 4
// 0 1 0     5 5 100

// 000 000 000

const [n, m] = input.shift().split(' ').map(v => +v);
const array = input.map(v => v.split(' ').map(el => +el));
const sum = Array.from(Array(n), () => Array(m).fill(0));

for(let i = 0; i < n; i++){
  for(let j = 0; j < m; j++){
    sum[i][j] = array[i][j] + array[i + n][j];
  }
}

let answer = '';

for(let i = 0; i < n; i++){
  for(let j = 0; j < m; j++){
    answer += sum[i][j] + ' ';
  }
  answer += '\n';
}

console.log(answer);