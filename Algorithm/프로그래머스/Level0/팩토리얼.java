package Algorithm.프로그래머스.Level0;
// https://school.programmers.co.kr/learn/courses/30/lessons/120848

class Solution {
  public int solution(int n) {
      int ans = 0;
      
      for(int i = 1; i <= n; i++){
          if(isFactorial(i) <= n){
              ans = i;
          }else {
              break;
          }
      }
      
      return ans;
  }
  
  public int isFactorial(int num) {
      int result = 1;
      for(int i = num; i > 1; i--) result *= i;
      
      return result;
  }
}