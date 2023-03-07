function solution(s){
  let stack = []; // 스택 빈 배열.

  for(let i = 0; i < s.length; i++){
    
    // 스택 배열이 비어있거나, 스택의 마지막 요소가 현재 인덱스의 문자와 같지 않다면,
    !stack || stack[stack.length-1] !== s[i]
    ? stack.push(s[i]) // 현재 인덱스의 문자 push.
    : stack.pop() // 스택 배열의 마지막 요소 pop.
  }

  // 전부 짝을 지어 제거했으면 1, 아니면 0.
  return stack.length === 0 ? 1 : 0;
}