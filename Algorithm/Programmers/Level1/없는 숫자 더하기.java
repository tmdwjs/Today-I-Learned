// https://school.programmers.co.kr/learn/courses/30/lessons/86051?language=java


class Solution {
  public int solution(int[] numbers) {
      int ans = 0;
      
      for (int i = 0; i <= 9; i++) {
          if (!hasNum(numbers, i)) {
              ans += i;
          }
      }
      
      return ans;
  }
  
  public static boolean hasNum(int[] numbers, int i) {
      for (int j = 0; j < numbers.length; j++) {
          if (numbers[j] == i) return true;
      }
      
      return false;
  }
}