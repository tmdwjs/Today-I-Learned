// https://school.programmers.co.kr/learn/courses/30/lessons/120905

import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int n, int[] numlist) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < numlist.length; i++){
            if(numlist[i] % n == 0){
                list.add(numlist[i]);
            }
        }
        
        return list;
    }
}