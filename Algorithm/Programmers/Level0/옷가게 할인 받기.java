// https://school.programmers.co.kr/learn/courses/30/lessons/120818

class Solution {
  public int solution(int price) {
      double answer = 0;
      
      if(price < 100000){
          answer = (double)price;
      }else if(100000 <= price && price < 300000){
          answer = (double)price * 0.95;
      }else if(300000 <= price && price < 500000 ){
          answer = (double)price * 0.9;
      }else if(price >= 500000){
          answer = (double)price * 0.8;
      }
      
      return (int)answer;
  }
}