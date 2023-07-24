function solution(survey, choices) {
  const mbti = {R: 0, T: 0, C: 0, F: 0, J: 0, M: 0, A: 0, N: 0}
  let answer = '';
  
  for(let i = 0; i < survey.length; i++){
      if(choices[i] < 4){
          mbti[survey[i][0]] += 4 - choices[i];
      }else{
          mbti[survey[i][1]] += choices[i] - 4;
      }
  }
  
  answer += mbti['R'] >= mbti['T'] ? 'R' : 'T';
  answer += mbti['C'] >= mbti['F'] ? 'C' : 'F';
  answer += mbti['J'] >= mbti['M'] ? 'J' : 'M';
  answer += mbti['A'] >= mbti['N'] ? 'A' : 'N';
  
  return answer;
}