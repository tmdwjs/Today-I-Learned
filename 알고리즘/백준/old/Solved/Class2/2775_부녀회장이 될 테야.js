const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input.shift();

for(let i = 0; i < n; i++){
  const k = +input.shift(); // k층
  const n = +input.shift(); // n호

  // 아파트 배열 층은 0층부터 시작하니 k + 1, 1호부터 1명이 사니, n + 1
  const apt = Array.from(Array(k + 1), () => Array(n + 1).fill(0));
  // 아파트 1층
  for(let i = 1; i <= n; i++) apt[0][i] = i;

  for(let i = 1; i <= k; i++){
    for(let j = 1; j <= n; j++){
      apt[i][j] = apt[i-1][j] + apt[i][j-1];
    }
  }

  console.log(apt[k][n]);
}