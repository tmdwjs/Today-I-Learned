// https://school.programmers.co.kr/learn/courses/30/lessons/120844

class Solution {
  public int[] solution(int[] numbers, String direction) {
      int[] arr = new int[numbers.length];
      
      if(direction.equals("right")) {
          for(int i = 0; i < numbers.length; i++){
              arr[(i+1) % numbers.length] = numbers[i];
          }
      }else if(direction.equals("left")){
          for(int i = 0; i < numbers.length; i++){
              arr[i] = numbers[(i+1) % numbers.length];
          }
      }
      
      return arr;
  }
}