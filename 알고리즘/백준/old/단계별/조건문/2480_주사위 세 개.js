const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ');

const [one, two, three] = input.map(v => +v);
let answer;

if(one === two && one === three) answer = 10000 + (one * 1000);
if(one !== two || one !== three || two !== three){
  if(one !== two && one !== three) answer = 1000 + (two * 100);
  if(two !== three) answer = 1000 + (one * 100);
}
if(one !== two && one !== three && two !== three) answer = Math.max(...[one, two, three]) * 100;

console.log(answer);