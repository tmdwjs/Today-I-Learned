// https://school.programmers.co.kr/learn/courses/30/lessons/132267

class Solution {
  public int solution(int a, int b, int n) {
      int bottle = 0;
      int mod = 0;
      
      while (true) {
          if (n < a) break;
          
          bottle += (n / a) * b;
          mod = n % a;
          n = (n / a) * b + mod;
      }
      
      return bottle;
  }
}