const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split('\n');

let [hour, minute] = input[0].split(' ').map(v => +v);
let watch = Number(input[1]);

minute += watch;

// 조건문이 아니라, 80분, 1000분 이렇게 들어올 수 있기 때문에,
// 반복문으로 계속 60분을 넘어가면 초기화 해준다.
while(minute >= 60){
  minute -= 60;
  hour += 1;
}

hour %= 24; // 시간 문제에서 활용하면 좋을 것 같다.

console.log(hour, minute);