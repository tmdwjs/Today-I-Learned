// https://school.programmers.co.kr/learn/courses/30/lessons/120883

class Solution {
  public String solution(String[] id_pw, String[][] db) {
      String ans = "fail";
      
      for(int i = 0; i < db.length; i++) {
          if (db[i][0].equals(id_pw[0])) {
              if (db[i][1].equals(id_pw[1])) {
                  ans = "login";
              } else {
                  ans = "wrong pw";
              }
          }
      }
      
      return ans;
  }
}
