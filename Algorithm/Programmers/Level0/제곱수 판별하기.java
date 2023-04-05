// https://school.programmers.co.kr/learn/courses/30/lessons/120909

class Solution {
  public int solution(int n) {
      int answer = 2;
      int sqrt = (int)Math.sqrt((double)n);
      
      if(sqrt*sqrt == n) answer = 1;
      
      return answer;
  }
}