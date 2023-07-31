const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input[0];
const arr = input.slice(1).map(v => v.split(''));


for(let i = 0; i < n; i++){
  let answer = 0;

  for(let j = 0; j < arr[i].length; j++){
    arr[i][j] === '(' ? answer += 1 : answer -=1;

    if(answer < 0) break;
  }

  console.log(answer === 0 ? 'YES' : 'NO');
}