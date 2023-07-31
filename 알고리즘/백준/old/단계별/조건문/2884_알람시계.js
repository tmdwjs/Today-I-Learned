const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ');

let hour = Number(input[0]);
let minute = Number(input[1]);

minute -= 45;

if(minute < 0) {
  minute += 60;
  hour -= 1;

  if(hour < 0) {
    hour += 24;
  }
}

console.log(hour, minute);