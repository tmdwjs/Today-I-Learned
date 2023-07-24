// https://school.programmers.co.kr/learn/courses/30/lessons/120836

class Solution {
  public int solution(int n) {
      int answer = 0;
      
      // 배열은 필요 없고, 1부터 증가하면서 나누어 떨어진다면, 카운트
      for(int i = 1; i <= n; i++){
          if(n % i == 0){
              answer++;
          }
      }
      
      return answer;
  }
}