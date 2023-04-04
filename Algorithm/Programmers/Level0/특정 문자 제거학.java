// https://school.programmers.co.kr/learn/courses/30/lessons/120826

class Solution {
  public String solution(String my_string, String letter) {
      String answer = "";
      answer = my_string.replace(letter, "");
      return answer;
  }
}