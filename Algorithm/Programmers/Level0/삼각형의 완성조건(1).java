// https://school.programmers.co.kr/learn/courses/30/lessons/120889

import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        
        if(sides[0] + sides[1] > sides[2]) {
            return 1;
        }else {
            return 2;
        }
    }
}