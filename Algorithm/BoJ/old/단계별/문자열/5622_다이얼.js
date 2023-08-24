const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

const arr = input.split('');
const dial = [[], [], ['A', 'B', 'C'], ['D', 'E', 'F'], ['G', 'H', 'I'], ['J', 'K', 'L'], ['M', 'N', 'O'], ['P', 'Q', 'R', 'S'], ['T', 'U', 'V'], ['W', 'X', 'Y', 'Z']];
let time = 0;

for(let i = 0; i < arr.length; i++){
  for(let j = 0; j < dial.length; j++){
    if(dial[j].includes(arr[i])) time += j + 1;
  }
}

console.log(time);