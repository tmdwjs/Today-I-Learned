// 시간 초과
// const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ');

// const [A, B, V] = input.map(v => +v);
// let goal = 0;
// let day = 0;

// while(true){
//   goal += A;
//   day ++;
//   if(goal === V) break;
//   goal -= B;
// }

// console.log(day);

const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ');

const [A, B, V] = input.map(v => +v);

console.log(Math.ceil((V-B) / (A-B)));

// 50m씩 100m 가려면?
// 100m/50m > 2일

// 50m 갔다 25m씩 100m 가려면?
// 50m 25m, 75m 50m, 125m > 3일
// 100m/25m > 4일 (X)
// 100m-25m / 50m-25m > 75m/25m > 3일(O)

// 만약 3.1일 걸린다면? 올림해서 4일이 걸림
// 따라서 Math.ceil() 메서드를 사용해 올림해서 정답 return