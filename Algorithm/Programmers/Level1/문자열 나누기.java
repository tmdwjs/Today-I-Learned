// https://school.programmers.co.kr/learn/courses/30/lessons/140108

class Solution {
    public int solution(String s) {
        int ans = 0;
        char c = s.charAt(0);
        int idx = 0;
        int diff = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (idx == diff) {
                c = s.charAt(i);
                ans++;
            }
            
            if (c == s.charAt(i)) {
                idx ++;
            } else {
                diff ++;
            }
        }
        
        return ans;
    }
}