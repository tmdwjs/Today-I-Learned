const input = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : __dirname + '/input.txt').toString().trim().split(' ');

const croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z='];
let str = input[0];
let answer = 0;

for(let i = 0; i < croatia.length; i++){
  // 받아온 문자열(input[0])에 크로아티아어가 있으면 공백으로 대체할 건데, 
  // 기존 input[0]과 다르다면 반복문 실행 즉, 지워진 게 있을 때만 실행하는 거임.
  // 지워졌다면 개수를 카운트 해 줘야 하니까.
  while(str !== str.replace(croatia[i], '')){
    answer++;
    str = str.replace(croatia[i], ' ');
  }
}

console.log(answer + str.split(' ').join('').length);

// 주어진 크로아티아 문자를 배열로 만들어 대체해준다.
// 제거 후 카운팅 한 숫자와 남은 문자 개수 합치면 끝