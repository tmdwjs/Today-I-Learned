const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = input.shift();
const count = [];
const str = [];
const arr = input.map(v => v.split(' '));
arr.forEach(v => {
  count.push(+v[0])
  str.push(v[1].split(''))
})

for(let i = 0; i < n; i++){
  let answer = '';

  for(let j = 0; j < str[i].length; j++){
    for(let k = 0; k < count[i]; k++){
      answer += str[i][j];
    }
  }

  console.log(answer);
}