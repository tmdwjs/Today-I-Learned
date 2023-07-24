// https://school.programmers.co.kr/learn/courses/30/lessons/131701

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        // 1. 중복 허용하지 않는 Set 변수 선언
        Set<Integer> set = new HashSet<>();
        
        // 2. 분할 정복을 위한 배열의 길이를 두 배로 늘리기
        int[] newEl = new int[elements.length * 2];
        
        // 3. elements 배열을 복사하는 로직
        for (int i = 0; i < elements.length; i++) {
            newEl[i] = newEl[i + elements.length] = elements[i];
        }
        
        // 4. newEl을 돌며 set에 추가
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(newEl, j, j + i).sum());
            }
        }
        
        return set.size();
    }
}