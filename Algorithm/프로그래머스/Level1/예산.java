package Algorithm.프로그래머스.Level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12982?language=java

import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int total = 0;
        int team = 0;
        
        Arrays.sort(d);
        
        for (int i = 0; i < d.length; i++) {
            total += d[i];
            if (total > budget) break;
            team ++;
            
        }
        
        return team;
    }
}