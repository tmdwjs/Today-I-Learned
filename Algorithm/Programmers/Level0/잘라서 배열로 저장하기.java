// https://school.programmers.co.kr/learn/courses/30/lessons/120913

import java.util.*;

class Solution {
    public ArrayList<String> solution(String my_str, int n) {
        ArrayList<String> list = new ArrayList<String>();
        
        for(int i = 0; i < my_str.length() / n; i++){
            list.add(my_str.substring((n * i), (n * (i + 1))));
        }
        
        if(my_str.length() % n != 0){
            list.add(my_str.substring( (my_str.length()) - (my_str.length() % n) ));
        }
        
        return list;
    }
}