// https://school.programmers.co.kr/learn/courses/30/lessons/147355

import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int tlen = t.length();
        int plen = p.length();
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < tlen - (plen - 1); i++) {
            list.add(t.substring(i, Math.min(tlen, i + plen)));
        }
        
        for (int i = 0; i < list.size(); i++) {
            if (Long.parseLong(list.get(i)) <= Long.parseLong(p))
                answer ++;
        }
        
        return answer;
    }
}