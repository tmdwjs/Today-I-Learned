// https://school.programmers.co.kr/learn/courses/30/lessons/120846

class Solution {
  public int solution(int n) {
      int answer = 0;
      
      for(int i = 1; i <= n; i++){
          int check = 0;
          
          for(int j = 1; j <= i; j++){
              if(i % j == 0) check += 1;
          }
          
          if(check >= 3) answer += 1;
      }
      
      return answer;
  }
}