// https://school.programmers.co.kr/learn/courses/30/lessons/120871

class Solution {
  public int solution(int n) {
      int answer = 0;
      
      for (int i = 0; i < n; i++) {
          answer++ ;
          
          while (answer % 3 == 0 || String.valueOf(answer).contains("3")) answer++;
      }
      
      return answer;
  }
}