const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const [a, b, c] = input.map(v => +v);
const n = a * b * c;
const copied = n.toString().split('');

const len = {
  '0': 0,
  '1': 0,
  '2': 0,
  '3': 0,
  '4': 0,
  '5': 0,
  '6': 0,
  '7': 0,
  '8': 0,
  '9': 0,
};

for(let i of copied){
 len[i]++;
}

console.log(Object.values(len).join('\n'));