const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input;

for(let i = 0; i < n; i++) {
  let star = '';

  for(let j = n - 1; j >= 0; j--){
    star += i >= j ? '*' : ' ';
  }
  console.log(star);
}