function solution(answers) {
  var result = [];
  
  let number1 = [1, 2, 3, 4, 5];                  // 1번 수포자 배열
  let number2 = [2, 1, 2, 3, 2, 4, 2, 5];         // 2번 수포자 배열
  let number3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];   // 3번 수포자 배열
  let count = [0, 0, 0]                           // [1번, 2번, 3번]
  
  for (let i = 0; i < answers.length; i++) {
      if (number1[i % number1.length] === answers[i]) count[0]++;
      if (number2[i % number2.length] === answers[i]) count[1]++;
      if (number3[i % number3.length] === answers[i]) count[2]++;
  };
  
  // 가장 큰 숫자 반환
  let top = Math.max(...count);
  
  // count 배열만큼 for문을 돌려 가장 높은 
  for (let j = 0; j < count.length; j++) {
      if (top === count[j]) {
          result.push(j+1); // 배열은 0, 1, 2로 출력되니 +1만큼 해줘서 result에 담기
      };
  };
  
  return result;
}