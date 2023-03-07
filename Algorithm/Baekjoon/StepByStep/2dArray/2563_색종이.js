const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input.shift(); // 색종이 개수
const papers = input.map(v => v.split(' ').map(el => +el));
const array = Array.from(Array(100), () => Array(100).fill(0)); // 100*100 도화지

// 색종이가 3개이니, 반복문 3번
for(let i = 0; i < n; i++){
  let dx = papers[i][0];
  let dy = papers[i][1];
  
  for(let j = 0; j < 10; j++){
    for(let k = 0; k < 10; k++){
      array[dx+j][dy+k] = 1;
    }
  }
}

const answer = array.reduce((acc, cur) => {
  for(let el of cur) if(el) acc++;
  return acc;
}, 0)

console.log(answer);