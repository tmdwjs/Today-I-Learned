let input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();
input = +input;
let movie = 666;
let count = 1;

while(input !== count){
  movie++
  if(String(movie).includes('666')) count++;
}

console.log(movie);