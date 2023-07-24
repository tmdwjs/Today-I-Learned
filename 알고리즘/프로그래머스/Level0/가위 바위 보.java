// https://school.programmers.co.kr/learn/courses/30/lessons/120839

class Solution {
  public String solution(String rsp) {
      String answer = "";
      
      for(int i = 0; i < rsp.length(); i++){
          if(rsp.charAt(i) == '2'){
              answer += "0";
          }else if(rsp.charAt(i) == '0') {
              answer += "5";
          }else {
              answer += "2";
          }
      }
      
      return answer;
  }
}