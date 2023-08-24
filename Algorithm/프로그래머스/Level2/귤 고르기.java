// https://school.programmers.co.kr/learn/courses/30/lessons/138476

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // 1. 귤 배열을 돌며,
        // 해당 크기의 귤이 존재하면 +1, 없으면 1부터 신규 생성하며 hashMap에 put
        for (int el: tangerine) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }
        
        // 2. 귤의 key로 리스트 생성
        List<Integer> list = new ArrayList<>(map.keySet());
        
        // 3. Comparator를 Overriding 해 내림차순 정렬
        // 가장 최소한의 크기로 귤 고르기 = 가장 많은 개수부터 고르기 = 내림차순
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer k1, Integer k2) {
                int val1 = map.get(k1);
                int val2 = map.get(k2);
                
                if (val1 == val2) return 0;
                else if (val1 < val2) return 1;
                else return -1;
            }
        });
        
        // 4. 반복문과 조건문으로 로직 처리
        for (int i = 0; i < list.size(); i++) {
            if (k <= 0) break;
            
            k -= map.get(list.get(i));
            answer ++;
        }
        
        return answer;
    }
}