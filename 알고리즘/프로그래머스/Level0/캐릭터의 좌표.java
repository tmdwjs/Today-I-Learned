// https://school.programmers.co.kr/learn/courses/30/lessons/120861

class Solution {
  public int[] solution(String[] keyinput, int[] board) {
      int[] ans = new int[2];
      
      for (int i = 0; i < keyinput.length; i++) {
          if (keyinput[i].equals("left")) {
              ans[0]--;
              if (ans[0] < -(board[0] / 2)) ans[0] = -(board[0] / 2);
          }else if (keyinput[i].equals("right")) {
              ans[0]++;
              if (ans[0] > board[0] / 2) ans[0] = board[0] / 2;
          }else if (keyinput[i].equals("up")) {
              ans[1]++;
              if (ans[1] > board[1] / 2) ans[1] = board[1] / 2;
          }else {
              ans[1]--;
              if (ans[1] < -(board[1] / 2)) ans[1] = -(board[1] / 2);
          }
      }
      
      return ans;
  }
}