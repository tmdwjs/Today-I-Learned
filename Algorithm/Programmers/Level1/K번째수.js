function solution(array, commands) {
  let answer = [];
  for(key of commands){
      answer.push(array.slice(key[0]-1, key[1]).sort((a, b) => a - b)[key[2]-1])
  }
  return answer;
}