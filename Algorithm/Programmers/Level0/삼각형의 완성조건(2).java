// https://school.programmers.co.kr/learn/courses/30/lessons/120868

// 1. max - min < n <= max
// 2. n < max + min
// 3. max - min < n < max + min
// 4. n = (max + min) - (max - min) - 1

// 풀이 1
class Solution {
  public int solution(int[] sides) {
      int max = Math.max(sides[0], sides[1]);
      int min = Math.min(sides[0], sides[1]);
      return (max + min) - (max - min) - 1;
  }
}