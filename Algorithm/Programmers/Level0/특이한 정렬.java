// https://school.programmers.co.kr/learn/courses/30/lessons/120880

import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        // 1. List 생성
        List<Integer> list = new ArrayList<>();
        
        // 2. 처음 제공 받는 배열 오름차순
        Arrays.sort(numlist);
        
        // 3. 오름차순 한 배열을 List에 추가
        for (int i = 0; i < numlist.length; i++) list.add(numlist[i]);
        
        // 4. n2-n, n1-n을 한 이유는,
        // 배열 요소에서 매개변수로 받은 n을 뺀 값이 같을 때, 더 큰 배열 요소를 먼저 정렬할 것이기 때문에,
        // 오름차순 상에서 더 큰 수인 s2를 먼저 n을 빼고, s1-n을 한 값을 비교하기 위함임
        list.sort((n1, n2) -> Integer.compare(Math.abs(n2 - n), Math.abs(n1 - n)));
        
        // 5. 내림차순
        Collections.reverse(list);
        
        // 6. 출력
        return list.stream().mapToInt(el -> el).toArray();
    }
}