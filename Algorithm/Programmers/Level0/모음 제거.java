// https://school.programmers.co.kr/learn/courses/30/lessons/120849

import java.util.*;

class Solution {
    public String solution(String my_string) {
        String[] gatherArr = {"a", "e", "i", "o", "u"};
        List<String> list = Arrays.asList(gatherArr);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++){
            if(!list.contains(String.valueOf(my_string.charAt(i)))){
                sb.append(my_string.charAt(i));
            }
        } 
        return sb.toString();
    }
}