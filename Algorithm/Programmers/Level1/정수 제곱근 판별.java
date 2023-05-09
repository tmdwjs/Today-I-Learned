// https://school.programmers.co.kr/learn/courses/30/lessons/12934

class Solution {
  public long solution(long n) {
      double m = Math.sqrt((double) n);
      double answer = m % 1 == 0 ? Math.pow(m + 1, 2) : -1;
      return (long)answer;
  }
}