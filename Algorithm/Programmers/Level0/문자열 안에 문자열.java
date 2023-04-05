// https://school.programmers.co.kr/learn/courses/30/lessons/120908

class Solution {
  public int solution(String str1, String str2) {
      int answer = 2;
      
      if(str1.contains(str2)) {
          answer = 1;
      }
      
      return answer;
  }
}