// https://school.programmers.co.kr/learn/courses/30/lessons/120837

class Solution {
  public int solution(int hp) {
      int answer = 0;
      
      while(hp > 0) {
          if(hp >= 5){
              hp -= 5;
              answer++;
          }else if(hp < 5 && hp >= 3){
              hp -= 3;
              answer++;
          }else if(hp < 3){
              hp -=1;
              answer++;
          }
      }
      
      return answer;
  }
}