const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim();
const n = +input; // 숫자형 변환
const answer = [];
let cnt = 0; // 옮길 때마다 카운트

const hanoi = (n, from, other, to) => {
	if(!n) return; // 0일 때 return, 1이 들어와도 해당됨

  // 2개가 들어오면, 1부터 옮기기 시작 > 중간
	hanoi(n-1, from, to, other)
	answer.push([from, to]); // 시작과 끝을 배열에 계속 담아주고
	cnt++; // 옮긴 횟수 카운트

  // 중간 다리로 간 애를 다시 끝으로
	hanoi(n-1, other, from, to);
}

hanoi(n, 1, 2, 3);

console.log(cnt);
console.log(answer.map(v => v.join(' ')).join('\n'));