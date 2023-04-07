// https://school.programmers.co.kr/learn/courses/30/lessons/120886

import java.util.*;

class Solution {
    public int solution(String before, String after) {
        return AToB(before, after);
    }
    
    public int AToB(String before, String after){
        // [1] Map 생성
        Map<Character, Integer> mapBefore = new HashMap<Character, Integer>();
        Map<Character, Integer> mapAfter = new HashMap<Character, Integer>();
        
        // [2] Before Map
        for(char el: before.toCharArray()){
            int count = mapBefore.getOrDefault(el, 0);
            mapBefore.put(el, count + 1);
        }
        
        // [3] After Map
        for(char el: after.toCharArray()){
            int count = mapAfter.getOrDefault(el, 0);
            mapAfter.put(el, count + 1);
        }
        
        // [4] Map 비교
        for(char el: mapBefore.keySet()){
            if(!mapAfter.containsKey(el) || mapBefore.get(el) > mapAfter.get(el)) {
                return 0;
            }
        }
        
        return 1;
    }
}