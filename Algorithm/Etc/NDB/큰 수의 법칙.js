// 문제 출처: 이것이 취업을 위한 코딩 테스트다 with 파이썬 - 나동빈 지음
// 오직 학습 목적이며 상업적 목적으로 사용되지 않았음을 밝힙니다.

// M회만큼 더하고, 연속으로 더할 수 있는 횟수는 K회로 제한을 한다.
// M: 8, K: 3
// 입력 자연수 2 4 5 4 6

const input = require('fs').readFileSync(__dirname + '/input.txt').toString().split('\n');

let num = Number(input[0]); // 8회
let cut = Number(input[1]); // 3번까지만 연속

let arr = input[2].split(' '); // ['2', '4', '5', '4', '6']

let first = arr[0];  // '2'
let second = arr[1]; // '4'

let answer = 0;

// 어차피 큰 수만 더할 것이니 내림차순 정렬
arr.sort((a, b) => b - a);

// 참일 때 반복문
while(true){
  if(num === 0) break; // 횟수가 0이 되면 반복문 중지

  for(let i = 0; i < cut; i++){
    answer += Number(first); // 가장 큰 수만 더해주기
    cut --; // 연속 횟수 제한
  }

  // 횟수 제한 다 썼으면 다음 큰 수 더하기
  if(cut === 0){
    answer += Number(second);
    cut += 1; // 다시 기회 부여
  }

  num --;
}

console.log(answer); // 46