const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

const arr = input.split(' ');

if(arr.length !== 1) console.log(arr.length);

if(arr.length === 1){
  if(arr[0] === '') console.log(0);
  else console.log(arr.length);
}