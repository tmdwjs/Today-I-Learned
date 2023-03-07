function solution(n, lost, reserve) {
  // 정답 = 전체 학생 수 - 도난 당한 학생 수
  let answer = n - lost.length;
  // 도난 당한 학생들 필터링
  let newLost = lost.filter((e) => {return !reserve.includes(e)});
  // 여분 있는 학생들 필터링
  let newReserve = reserve.filter((e) => {return !lost.includes(e)});
  // 빌려줄 순 없지만 수업 참여는 가능하니 answer++
  answer += lost.length - newLost.length;
  
  // 도난 당한 학생 오름차순
  newLost.sort((a, b) => {return a - b});
  
  newLost.map((e) => {
      if(newReserve.includes(e - 1)){ // 여분 학생이 왼쪽 위치 시
          // 빌려주고 필터링(그리고 answer++)
          newReserve = newReserve.filter((value) => {return value !== e - 1})
          answer++;
      }else if(newReserve.includes(e + 1)){ // 여분 학생이 오른쪽 위치 시
          // 빌려주고 필터링(그리고 answer++)
          newReserve = newReserve.filter((value) => {return value !== e + 1})
          answer++;
      }
  })
  
  return answer;
}