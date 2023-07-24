const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

// input
// 8 8
// WBWBWBWB
// BWBWBWBW
// WBWBWBWB
// BWBBBWBW
// WBWBWBWB
// BWBWBWBW
// WBWBWBWB
// BWBWBWBW

const [N, M] = input.shift().split(' ').map(Number); // 8X8
const answer = []; // white로 시작하는 판과, black으로 시작하는 체스판 비교하기 위한 배열

// white로 먼저 시작하는 8X8 체스판
const whiteBoard = [
  'WBWBWBWB',
  'BWBWBWBW',
  'WBWBWBWB',
  'BWBWBWBW',
  'WBWBWBWB',
  'BWBWBWBW',
  'WBWBWBWB',
  'BWBWBWBW'
]

// black으로 먼저 시작하는 8X8 체스판
const blackBoard = [
  'BWBWBWBW',
  'WBWBWBWB',
  'BWBWBWBW',
  'WBWBWBWB',
  'BWBWBWBW',
  'WBWBWBWB',
  'BWBWBWBW',
  'WBWBWBWB'
]

// white로 시작하는 체스판 체크하는 함수
function checkWhiteBoard(x, y) {
  let count = 0;

  for (let i = x; i < x + 8; i++) {
    for (let j = y; j < y + 8; j++) {
      if (input[i][j] !== whiteBoard[i - x][j - y]) {
        count++;
      }
    }
  }

  return count;
}

// black으로 시작하는 체스판 체크하는 함수
function checkBlackBoard(x, y) {
  let count = 0;

  for (let i = x; i < x + 8; i++) {
    for (let j = y; j < y + 8; j++) {
      if (input[i][j] !== blackBoard[i - x][j - y]) {
        count++;
      }
    }
  }

  return count;
}

for (let i = 0; i + 7 < N; i++) {
  for (let j = 0; j + 7 < M; j++) {
    answer.push(checkWhiteBoard(i, j));
    answer.push(checkBlackBoard(i, j));
  }
  
}

console.log(Math.min(...answer));