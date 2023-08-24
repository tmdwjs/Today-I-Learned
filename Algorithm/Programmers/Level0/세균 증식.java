// https://school.programmers.co.kr/learn/courses/30/lessons/120910

class Solution {
  public int solution(int n, int t) {
      int ans = n;
      for(int i = 0; i < t; i++) ans *= 2;
      return ans;
  }
}