// https://school.programmers.co.kr/learn/courses/30/lessons/120862

class Solution {
  public int solution(int[] numbers) {
      int max = -100000000;
      int len = numbers.length;
      
      for(int i = 0; i < len; i++){
          for(int j = i + 1; j < len; j++){
              if(numbers[i] * numbers[j] > max) {
                   max = numbers[i] * numbers[j];
              }
          }
      }
      
      return max;
  }
}