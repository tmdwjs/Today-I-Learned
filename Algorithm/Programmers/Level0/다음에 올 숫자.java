// https://school.programmers.co.kr/learn/courses/30/lessons/120924

class Solution {
  public int solution(int[] common) {
      int ans = 0;
      int rule = 0;
      
      if (common[1] - common[0] == common[2] - common[1]) {
          rule = common[1] - common[0];
          ans = common[common.length - 1] + rule;
      } else if (common[1] / common[0] == common[2] / common[1]) {
          rule = common[1] / common[0];
          ans = common[common.length - 1] * rule;
      }
          
      return ans;
  }
}