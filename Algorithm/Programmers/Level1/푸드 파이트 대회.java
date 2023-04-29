// https://school.programmers.co.kr/learn/courses/30/lessons/134240

import java.lang.*;

// [풀이 1] 단순 계산
class Solution1 {
  public String solution(int[] food) {
      String answer = "";
      String reverse = "";
      
      for (int i = 0; i < food.length; i++) {
          for (int j = 0; j < food[i] / 2; j++) {
              answer += String.valueOf(i);
          }
      }
      
      for (int i = answer.length() - 1; i >= 0; i--) {
          reverse += String.valueOf(answer.charAt(i));
      }
      
      return answer + "0" + reverse;
  }
}

// [풀이 2] StringBuilder.reverse() 사용
class Solution2 {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(String.valueOf(i));
            }
        }
        
        return sb.toString() + "0" + sb.reverse().toString();
    }
}