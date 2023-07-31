const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

let result = 0;

for(let i = 1; i <= +input; i++){
  const sum = i + i.toString().split('').map(v => +v).reduce((acc, cur) => acc + cur, 0);

  if(sum === +input){
    result = i
    break;
  }
}

console.log(result);