// https://school.programmers.co.kr/learn/courses/30/lessons/120850

import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String my_string) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < my_string.length(); i++){
            if(Character.isDigit(my_string.charAt(i))){
                list.add(my_string.charAt(i)-'0');
            }
        }
        
        Collections.sort(list);
        
        return list;
    }
}