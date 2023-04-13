const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const array = input.map(v => v.split(' ').map(el => +el));
let max = 0;
let maxI = 0;
let maxJ = 0;

for(let i = 0; i < array.length; i++){
  for(let j = 0; j < array[i].length; j++){
    if(max < array[i][j]){
      max = array[i][j];
      maxI = i + 1;
      maxJ = j + 1;
    }
  }
}

console.log(max);
console.log(maxI, maxJ);

// 100%까지 가서 런타임 에러 떠서 답안은 다른 분 거 제출했습니다.