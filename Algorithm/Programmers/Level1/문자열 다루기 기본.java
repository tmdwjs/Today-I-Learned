// https://school.programmers.co.kr/learn/courses/30/lessons/12918?language=java

class Solution {
  public boolean solution(String s) {
      if (s.length() != 4 && s.length() != 6) {
          return false;
      } else {
          try {
              if (Integer.parseInt(s) % 1 == 0) return true;
          } catch(Exception e) {
              return false;
          }
      }
      
      return true;
  }
}