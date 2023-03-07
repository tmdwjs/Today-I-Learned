const input = require('fs')
.readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt')
.toString()
.trim()
.split('\n')
.map(v => +v);

const n = input[0];

for(let i = 1; i <= n; i++){
  let now = input[i];
  let res = '';

  for(let j = 1; j < Math.sqrt(now); j++){
    if(j + j**2 > now){
      break;
    }
    res = j;
  }

  console.log(res || 0);
}