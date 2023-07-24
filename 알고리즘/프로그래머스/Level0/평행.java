// https://school.programmers.co.kr/learn/courses/30/lessons/120875

class Solution {
  public int solution(int[][] dots) {
      int answer = 0;
      
      int lean1 = ((dots[2][1] - dots[0][1]) / (dots[2][0] - dots[0][0])) 
          + ((dots[2][1] - dots[0][1]) % (dots[2][0] - dots[0][0]));
      int lean2 = ((dots[3][1] - dots[1][1]) / (dots[3][0] - dots[1][0])) 
          + ((dots[3][1] - dots[1][1]) % (dots[3][0] - dots[1][0]));
      
      if (lean1 == lean2) answer = 1;
      
      return answer;
  }
}