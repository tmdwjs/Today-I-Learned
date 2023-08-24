const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const N = Number(input.shift());

const specs = input.map(spec => spec.split(' ').map(num => Number(num)));
const rank = [];

for(let i = 0; i < N; i++){
  let count = 0;

  for(let j = 0; j < N; j++){
    if(specs[i] !== specs[j]){
      if(specs[i][0] < specs[j][0] && specs[i][1] < specs[j][1]) count++;
    }
  }

  rank.push(count+1);
}

console.log(rank.join(' '));