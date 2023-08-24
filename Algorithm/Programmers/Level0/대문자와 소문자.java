// https://school.programmers.co.kr/learn/courses/30/lessons/120893

class Solution {
  public String solution(String my_string) {
      String answer = "";
      
      // 유니코드 번호 추출 및 범위에 해당하면 대소문자로 변환
      for(int i = 0; i < my_string.length(); i++){
          if(my_string.codePointAt(i) >= 97 
             && my_string.codePointAt(i) <= 122) {
              answer += Character.toUpperCase(my_string.charAt(i));
          }else {
              answer += Character.toLowerCase(my_string.charAt(i));
          }
      }
      
      return answer;
  }
}