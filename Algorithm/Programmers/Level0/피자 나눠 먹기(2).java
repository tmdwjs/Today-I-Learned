// https://school.programmers.co.kr/learn/courses/30/lessons/120815

class Solution {
  public int solution(int n) {
      // 1. 6과 매개변수의 최소공배수 구하기
      // 2. 최소공배수 / 6(조각)이 답
      // 3. 최소공약수 먼저 구하고 -> 최소공배수 구하기
      
      // 1. 최대공약수
      int gcd = getGcd(6, n);
      
      // 2. 최소공배수
      int lcm = (6 * n) / gcd;
      
      // 3. 최소공배수 / 6
      int ans = lcm / 6;
      
      return ans;
  }
  
  // 최대 공약수 구하기
  private int getGcd(int a, int b) {
    if(b == 0) return a;
    return getGcd(b, a % b);
  }
}

