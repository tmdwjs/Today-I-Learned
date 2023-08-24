let input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

// 1, 6, 12, 18, 24, ........

input = +input;

let range = 1, block = 1;

while(block < input){
  block += range * 6;
  range++;
}

console.log(range);