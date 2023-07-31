const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();

const nums = input.split(' ').map(num => num.split(''));
const arr = [];

for(let i = 0; i < nums.length; i++){
  let reverse = '';

  for(let j = nums[i].length-1; j >= 0; j--){
    reverse += nums[i][j];
  }
  
  arr.push(reverse);
}

const ans = arr.map(v => +v).sort((a, b) => b - a);

console.log(ans[0]);