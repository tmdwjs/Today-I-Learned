// https://school.programmers.co.kr/learn/courses/30/lessons/120869

class Solution {
    public int solution(String[] spell, String[] dic) {
        int ans = 2;
        
        for (int i = 0; i < dic.length; i++) {
            boolean check = true;
            
            for (int j = 0; j < spell.length; j++) {
                if (dic[i].indexOf(spell[j]) == -1) {
                    check = false;
                }
            }
            
            if (check == true) ans = 1;
        }
        
        return ans;
    }
}