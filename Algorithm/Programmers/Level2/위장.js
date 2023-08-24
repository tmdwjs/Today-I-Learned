// https://school.programmers.co.kr/learn/courses/30/lessons/42578

function solution(clothes) {
  let answer = 1;
  let wear = {};

  for(let i = 0; i < clothes.length; i++){
  	wear[clothes[i][1]] = (wear[clothes[i][1]] || 1) + 1;
  }
  
  for(let value in wear){
  	answer *= wear[value];
  }

  return answer - 1;
}