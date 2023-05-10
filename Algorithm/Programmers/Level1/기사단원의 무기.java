// https://school.programmers.co.kr/learn/courses/30/lessons/136798

class Solution {
  public int solution(int number, int limit, int power) {
      int answer = 0;
      
      for (int i = 0; i < number; i++) {
          if (divisor(i + 1) > limit) {
              answer += power;
          } else {
              answer += divisor(i + 1);
          }
              
      }
      
      return answer;
  }
  
  public static int divisor(int n) {
      int count = 0;
      
      for (int i = 1; i <= Math.sqrt(n); i++) {
          if (n % i == 0) {
              if (Math.sqrt(n) == i) {
                  count += 1;
              } else {
                  count += 2;
              }
          }
      }
      
      return count;
  }
}