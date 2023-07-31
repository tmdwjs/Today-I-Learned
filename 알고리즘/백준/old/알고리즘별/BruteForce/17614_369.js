let input = require('fs')
.readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt')
.toString()
.trim();

input = +input;
let clap = 0;

for(let i = 1; i <= input; i++){
  clap += (i.toString().match(/[369]/g) || []).length;
}

console.log(clap);