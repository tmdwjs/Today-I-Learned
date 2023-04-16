// https://school.programmers.co.kr/learn/courses/30/lessons/120882

import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        // 1. List 생성
        List<Integer> list = new ArrayList<>();
        
        // 2. 평균 담기
        for (int[] el: score) list.add(el[0] + el[1]);
        
        // 3. 내림차순
        list.sort(Comparator.reverseOrder());
        
        // 4. 정답 담을 배열 생성
        int[] ans = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.indexOf(score[i][0] + score[i][1]) + 1;
        }
        
        return ans;
    }
}