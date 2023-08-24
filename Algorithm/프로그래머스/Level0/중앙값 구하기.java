// https://school.programmers.co.kr/learn/courses/30/lessons/120811

import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        // 1. 오름차순
        Arrays.sort(array);
        
        // 2. 중간값
        double mid = array.length / 2;
        
        return array[(int)mid];
    }
}