// https://school.programmers.co.kr/learn/courses/30/lessons/120845

class Solution {
  public int solution(int[] box, int n) {
      int answer = 0;
      
      int a = box[0] / n;
      int b = box[1] / n;
      int c = box[2] / n;
      
      answer = a * b * c;
      
      return answer;
  }
}