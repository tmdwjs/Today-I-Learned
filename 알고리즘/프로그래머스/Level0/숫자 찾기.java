// https://school.programmers.co.kr/learn/courses/30/lessons/120904

class Solution {
  public int solution(int num, int k) {
      String str = String.valueOf(num);
      int ans = 0;
      for(int i = 0; i < str.length(); i++){
          System.out.println("");
          if(String.valueOf(str.charAt(i)).equals(String.valueOf(k))){
              ans = i+1;
              break;
          }
      }
      
      if(ans == 0) {
          ans = -1;
      }
      
      return ans;
  }
}