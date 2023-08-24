const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

const n = +input[0]; // 개수
const arr = input.slice(1).map(v => +v).sort((a, b) => a - b); // 입력값

const avg = arr.reduce((acc, cur) => acc + cur, 0) / n; // 평균
const center = arr[Math.floor(arr.length / 2)]; // 중앙값
let mode = 0; // 최빈값
const range = arr[arr.length - 1] - arr[0]; // 범위

const obj = {}; // 최빈값 객체
const modeArr = []; // 최빈값 배열

// key : value 형태로 최빈값 저장
arr.forEach(v => obj[v] = ++obj[v] || 1)
// 가장 큰 value를 저장(여러 개면 여러 개)
const maxMode = Math.max(...Object.values(obj));

for(let key in obj){
  // 객체의 value가 최빈값에 해당되면 배열에 저장
  if(obj[key] === maxMode) modeArr.push(key)
}
// 최빈값 담은 배열 오름차순
const sortMode = modeArr.map(v => +v).sort((a, b) => a - b);

if(sortMode.length > 1) mode = sortMode[1]
else mode = sortMode[0]

console.log(`${Math.round(avg)}\n${center}\n${mode}\n${range}`);

// 최빈값 구하는 게 힘들었다.
// 최빈값 구하던 과정 다시 한 번 복습하기.