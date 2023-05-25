// https://school.programmers.co.kr/learn/courses/30/lessons/42587

package programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프로세스 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        // 1. 큐 생성(내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 2. 배열 -> 큐 담기
        // [9, 1, 1, 1, 1, 1]
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        // 3. 반복문
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                // priorities[2] = 9
                // pq.peek() = 9
                // 이때 조건문 실행
                if (priorities[i] == pq.peek()) {

                    // i = 2
                    // location = 0
                    // 조건문 실행 x
                    if (i == location) {
                        answer ++;
                        return answer;
                    }

                    pq.poll(); // pq.poll()
                                // 9 지우고, [1, 1, 1, 1] 됨
                    answer ++; // answer ++;
                }
            }
        }

        return answer;
    }
}