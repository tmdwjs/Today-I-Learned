// https://school.programmers.co.kr/learn/courses/30/lessons/120834

class Solution {
  public String solution(int age) {
      String[] arr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
                      "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
      String str = Integer.toString(age);
      String ans = "";
      
      for(int i = 0; i < str.length(); i++){
          ans += arr[str.charAt(i)-'0'];
      }
      
      return ans;
  }
}