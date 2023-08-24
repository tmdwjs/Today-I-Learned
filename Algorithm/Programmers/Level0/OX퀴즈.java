package Algorithm.Programmers.Level0;
// https://school.programmers.co.kr/learn/courses/30/lessons/120907

class Solution {
  public String[] solution(String[] quiz) {
      String[] answer = new String[quiz.length];
      String[][] arr = new String[quiz.length][5];
      
      for (int i = 0; i < quiz.length; i++) arr[i] = quiz[i].split(" ");
      
      for (int j = 0; j < arr.length; j++) {
          int real_ans = 0;
          int temp_ans = 0;
          
          for (int k = 0; k < arr[j].length; k++) {
              temp_ans = Integer.parseInt(arr[j][4]);
              
              if (arr[j][1].equals("+")) {
                  real_ans = 
                      Integer.parseInt(arr[j][0]) + Integer.parseInt(arr[j][2]);
              } else {
                  real_ans = 
                      Integer.parseInt(arr[j][0]) - Integer.parseInt(arr[j][2]);
              }
          }
          
          if (real_ans == temp_ans) answer[j] = "O";
          else answer[j] = "X";
      }
      
      return answer;
  }
}