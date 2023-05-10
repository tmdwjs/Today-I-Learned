// https://school.programmers.co.kr/learn/courses/30/lessons/12948?language=java

class Solution {
  public String solution(String phone_number) {
      int last_len = phone_number.length() - 4;
      int len = phone_number.length() - (phone_number.length() - last_len);
      String last = phone_number.substring(len);
      String answer = "";
      
      for (int i = 0; i < last_len; i++) answer += "*";
      
      return answer + last;
  }
}