// https://school.programmers.co.kr/learn/courses/30/lessons/120888

import java.util.*;

class Solution {
    public String solution(String my_string) {
        return removeDuplicates(my_string);
    }
    
    public String removeDuplicates(String str){
        Set<Character> set = new LinkedHashSet<Character>();
        for(char el: str.toCharArray()) set.add(el);
        
        StringBuilder sb = new StringBuilder();
        for(Character el: set) sb.append(el);
        
        return sb.toString();
    }
}