// https://school.programmers.co.kr/learn/courses/30/lessons/142086

class Solution {
  public int[] solution(String s) {
      int[] answer = new int[s.length()];
      
      // 1. 문자열만큼 반복문 돎
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i); // 2. 현재 순서의 알파벳과
          int count = 0; // 3. 몇 번째 위치해 있는지 카운트 하기 위한 변수
          
          // 4. 첫 번째는 무조건 -1
          if (i == 0) {
              count = -1;
              
          // 5. 현재 알파벳의 위치에서부터 역순으로 반복문을 돎
          }else {
              for (int j = i - 1; j >= 0; j--) {
                  count ++; // 6. 일단 +1
                  
                  // 7. 현재 알파벳과 직전 알파벳이 같으면
                  if (c == s.charAt(j)) {
                      break; // 8. 출력
                      
                  // 9. 또는 계속 반복문을 돌되,
                  } else {
                      
                      // 10. 끝까지 못 찾으면
                      if (j == 0) {
                          // -1을 할당하고 break
                          count = -1;
                          break;
                      }
                  }
              }
          }
                   
          answer[i] = count;
      }
      
      return answer;
  }
}