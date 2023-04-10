// https://school.programmers.co.kr/learn/courses/30/lessons/120860

class Solution {
  public int solution(int[][] dots) {
      int maxX = dots[0][0];
      int minX = dots[0][0];
      int maxY = dots[0][1];
      int minY = dots[0][1];
      
      for (int i = 0; i < dots.length; i++) {
          maxX = Math.max(maxX, dots[i][0]);
          minX = Math.min(minX, dots[i][0]);
          maxY = Math.max(maxY, dots[i][1]);
          minY = Math.min(minY, dots[i][1]);
      }
      
      int x = maxX - minX;
      int y = maxY - minY;
      
      return x * y;
  }
}