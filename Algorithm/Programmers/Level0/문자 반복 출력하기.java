// https://school.programmers.co.kr/learn/courses/30/lessons/120825

import java.lang.*;

class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++){
            for(int j = 0; j < n; j++){
                sb.append(my_string.charAt(i));
            }
            
        }
        
        return sb.toString();
    }
}