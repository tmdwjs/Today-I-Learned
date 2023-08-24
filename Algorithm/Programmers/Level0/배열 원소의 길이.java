// https://school.programmers.co.kr/learn/courses/30/lessons/120854

class Solution {
  public int[] solution(String[] strlist) {
      int[] ans = new int[strlist.length];
      
      for(int i = 0; i < strlist.length; i++){            
          ans[i] = strlist[i].length();
      }
      
      return ans;
  }
}