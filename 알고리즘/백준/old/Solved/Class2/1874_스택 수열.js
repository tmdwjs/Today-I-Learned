const input = require('fs')
.readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt')
.toString()
.trim()
.split('\n');

// 입력의 길이인 n과 숫자 타입 배열
let [n, ...arr] = input;
arr = arr.map(v => +v);

let start = 1; // 시작 num
// 1부터 시작해 해당 숫자와 작거나 같을 때까지 증가하며,
// 증가한 숫자를 stack 배열에 담으며 answer에 +로 이어줄 것

let stack = []; // stack 배열
let answer = ''; // answer

// 입력의 길이만큼 반복문 실행
for(let i = 0; i < n; i++){
  
  const el = arr.shift();
  // shift로, 입력 배열 순서대로 잘리며 el에 할당됨
  // 반복문이 돌 때마다 초기화 되니 const로 선언해도 될 듯

  // 현재 숫자보다 작거나 같을 때까지 점차 증가하며
  // answer에 +로 이어주기
  while(start <= el){
    stack.push(start++);
    answer += '+';
  }

  // stack에 제일 마지막 요소를 isPoped 변수에 할당해 주고,
  const isPoped = stack.pop();
  // 현재 요소가 stack의 맨 마지막 요소가 아니라면,
  // 해당 연산은 불가능한 연산이므로 문제대로 NO를 출력해 준다.
  if(isPoped !== el) answer += 'NO';

  // 해당 문제는 이론 상,
  // 처음 입력 받은 숫자 중, 가장 큰 숫자가 나오면
  // 그 이후론 계속 숫자가 작아지며 pop()으로 빼 내며 '-'를 찍어줘야 한다.
  // 하지만 예제 2번대로, 최고점 이후로 작아지다 이전보다 큰 숫자가 나오면 연산이 불가능하다 볼 수 있다.

  // while을 통과하든 안 하든, 빼내야 하니, pop()을 의미하는 '-'를 answer에 더해준다.
  answer += '-';
}

console.log(answer.includes('NO') ? 'NO' : answer.split('').join('\n'));
