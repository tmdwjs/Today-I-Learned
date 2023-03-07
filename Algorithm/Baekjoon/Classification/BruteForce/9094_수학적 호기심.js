let input = require('fs')
.readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt')
.toString()
.trim()
.split('\n');

const arr = input.slice(1).map(v => v.split(' ').map(el => +el));

for(let key of arr){
  const [n, m] = key;
  let res = 0;

  for(let i = 1; i < n - 1; ++i){
    for(let j = i + 1; j < n; ++j){
      if((i**2 + j **2 + m) % (i*j) === 0) res++;
    }
  }

  console.log(res);
}