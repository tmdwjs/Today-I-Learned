// https://school.programmers.co.kr/learn/courses/30/lessons/120822

class Solution {
  public String solution(String my_string) {
      String answer = "";
      String[] arr = my_string.split("");
      
      for(int i = 0; i < arr.length; i++){
          answer += arr[arr.length - 1 - i];
      }
      
      return answer;
  }
}