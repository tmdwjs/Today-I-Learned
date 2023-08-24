// https://school.programmers.co.kr/learn/courses/30/lessons/120808?language=java

class Solution {
  public int[] solution(int numer1, int denom1, int numer2, int denom2) {
      int[] answer = new int[2];
      
      // 1) 최대공약수 구하기(최소 공배수 구하기 위함)
      int gcd = getGcd(denom1, denom2);

      // 2) 최소공배수 구하기
      int lcm = (denom1 * denom2) / gcd;

      // 3) 최소공배수 기반으로 분자 구하기
      numer1 *= lcm / denom1;
      numer2 *= lcm / denom2;

      // 4) 기약 분수로 만들기
      int newNumer = numer1 + numer2;
      int newDemon = lcm;
      int newGcd = getGcd(newNumer, newDemon);

      answer[0] = newNumer / newGcd;
      answer[1] = newDemon / newGcd;
      
      return answer;
  }
  
  // 최대 공약수 구하기
  private int getGcd(int a, int b) {
      if(b == 0) return a;
      return getGcd(b, a % b);
  }
}