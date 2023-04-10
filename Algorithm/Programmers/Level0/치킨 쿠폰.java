// https://school.programmers.co.kr/learn/courses/30/lessons/120884

class Solution {
  public int solution(int chicken) {
      int coupon = chicken;
      int remain_coupon = 0;
      int service = 0;
      
      while (coupon >= 10) {
          service += coupon / 10;
          
          remain_coupon = coupon % 10;
          coupon = coupon / 10 + remain_coupon;
      }
      
      return service;
  }
}