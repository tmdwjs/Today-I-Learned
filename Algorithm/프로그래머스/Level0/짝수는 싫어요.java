// https://school.programmers.co.kr/learn/courses/30/lessons/120813

class Solution {
  public int[] solution(int n) {
      double len = Math.round((double)n/2);
      int[] answer = new int[(int)len];
      
      for(int i = 1; i <= n; i++){
          if(i % 2 != 0){
              answer[(i/2)] = i;
          }
      }
      
      return answer;
  }
}