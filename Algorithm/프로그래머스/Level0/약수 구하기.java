// https://school.programmers.co.kr/learn/courses/30/lessons/120897

import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                list.add(i);
            }
        }
        
        return list;
    }
}