// https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=java

import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] != arr[i]) list.add(arr[i]);
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}