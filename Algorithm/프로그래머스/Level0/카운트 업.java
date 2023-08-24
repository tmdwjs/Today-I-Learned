// https://school.programmers.co.kr/learn/courses/30/lessons/181920

class Solution {
  public int[] solution(int start, int end) {
      int[] answer = new int[end - start + 1];
      int n = 0;
      
      for (int i = start; i <= end; i++) {
          answer[n] = i;
          n++;
      }
      
      return answer;
  }
}