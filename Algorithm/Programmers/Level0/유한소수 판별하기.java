// https://school.programmers.co.kr/learn/courses/30/lessons/120878

class Solution {
  public int solution(int a, int b) {
      int ans = 1;
      double tmp = (double) a / (double) b;
      
      if (String.valueOf(tmp).length() >= 16) ans = 2;
          
      return ans;
  }
}