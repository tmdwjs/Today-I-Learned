// https://school.programmers.co.kr/learn/courses/30/lessons/12985?language=javascript

// 라운드는 1 라운드부터 시작이며, 특정 조건의 반복문이 돌 때마다 증가한다.

function solution(n, a, b){
  let round = 1;
  
  // 다음 번호 = 현재 번호 / 2
  // 이때, 홀수 번호의 다음 라운드 숫자를 고려해 반올림 해 주었다.
  const nextNum = (nowNum) => Math.ceil(nowNum / 2);

  // 선수 a와 b의 번호가 같지 않을 때 반복문 실행.
  // 만약 같으면 1 라운드에서 만난 것이니, 바로 round를 return 한다.
  while(a !== b){
    
    // 다음 라운드에서 만나면 반복문 종료.
    if(nextNum(a) === nextNum(b)) break;

    a = nextNum(a);
    b = nextNum(b);

    round ++;
  }

  return round;
}