// https://school.programmers.co.kr/learn/courses/30/lessons/132265

package programmers.level2;

import java.util.HashMap;

public class 롤케이크_자르기 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 3, 1, 4};
        System.out.println(solution(topping));
    }

    public static int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer, Integer> map_1 = new HashMap<>(); // 형
        HashMap<Integer, Integer> map_2 = new HashMap<>(); // 동생

        for (int el: topping) {
            map_1.put(el, map_1.getOrDefault(el, 0) + 1);
        }

        for (int el: topping) {
            map_2.put(el, map_2.getOrDefault(el, 0) + 1);

            if (map_1.get(el) - 1 == 0) {
                map_1.remove(el);
            } else {
                map_1.put(el, map_1.get(el) - 1);
            }

            if (map_1.size() == map_2.size()) {
                answer ++;
            }
        }

        return answer;
    }
}
