const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const arr = input.map(v => v.split(' ').map(el => +el)).slice(0, -1);

for(let i = 0; i < arr.length; i++){
  const [a, b, c] = arr[i].sort((a, b) => a - b);

  a**2 + b**2 === c**2 ? console.log('right') : console.log('wrong');
}