function solution(new_id) {
  var answer = new_id;

  answer = answer.toLowerCase(); // 1단계
  answer = answer.replace(/[^a-z0-9-_.]/g, ''); // 2단계
  answer = answer.replace(/\.+/g, '.'); // 3단계
  answer = answer.replace(/^\.|\.$/g, ''); // 4단계

  // 5단계
  if (answer == '') {
      answer += 'a'
  }
  
  // 6단계
  if (answer.length >= 16) {
      answer = answer.substring(0, 15);
  }
  answer = answer.replace(/\.$/, '');
  
  // 7단계
  while (answer.length <= 2) {
      answer += answer.charAt(answer.length -1);
  }

  return answer;
}