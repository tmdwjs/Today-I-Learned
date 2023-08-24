// https://school.programmers.co.kr/learn/courses/30/lessons/42586

// 남은 배포 일수 = 올림((100 - 진도) / 속도)

function solution(progresses, speeds) {
  let answer = [];

  // 100% 중에서 현재 진척도를 빼주고, 현재 인덱스의 속도로 나눠줘야,
  // 남은 배포 일수를 알 수 있다.
  const remainDay = progresses.map((p, i) => Math.ceil((100 - p) / speeds[i]))
  
  // 먼저 개발이 돼도, 앞 기능이 먼저 배포되어야 하기 때문에,
  // 비교를 위해 우선순위가 높은 기능을 변수에 할당한다.
  let first = remainDay[0];

  answer.push(0); // 0부터 카운트 될 것.

  for(let i = 0; i < remainDay.length; i++){
    
    // 남은 배포 일수가 우선순위 높은 기능보다 적으면,
    if(remainDay[i] <= first){
      // 우선순위 기능이 배포가 다 된 후에 같이 배포가 된다.
      answer[answer.length-1] += 1;
      
	// 남은 배포 일수가 우선순위 높은 기능보다 많으면,
    }else {
      answer.push(1);		// 새로운 요소 추가.
      first = remainDay[i]; // 비교 기준 재할당.
    }
  }        

  return answer;
}