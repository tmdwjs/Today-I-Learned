// https://school.programmers.co.kr/learn/courses/30/lessons/12943?language=java

class Solution {
  public int solution(long num) {
      int count = 0;
      
      if (num == 1) {
          return count;
      } else {
          for (int i = 0; i < 500; i++) {
              num = num % 2 == 0 ? num / 2 : num * 3 + 1;
              count ++;

              if (num <= 1) break;
              if (count >= 500) count = -1;
          }
      }
      
      return count;
  }
}

// 자바는 매개변수 num을 int가 아닌 long으로 받아야 한다
// 근데 기본 문제 세팅이 num이라 많이 헷갈렸음