// https://school.programmers.co.kr/learn/courses/30/lessons/42587

package Algorithm.프로그래머스.Level2;

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

// 2회차

// https://school.programmers.co.kr/learn/courses/30/lessons/42587

// package programmers.level2;

// import java.util.Collections;
// import java.util.PriorityQueue;

// public class 프로세스_2 {
//     public static void main(String[] args) {
//         int[] priorities = {2, 1, 3, 2};
//         int location = 2;
//         System.out.println(solution(priorities, location));
//     }

//     public static int solution(int[] priorities, int location) {
//         int answer = 0;

//         // 1. Queue 선언
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

//         // 2. priorities 담기
//         // 우선순위 높은 순서로 담길 것
//         for (int i = 0; i < priorities.length; i++) {
//             pq.add(priorities[i]); // [3, 2, 2, 1]
//         }

//         // 3. 반복문
//         while (!pq.isEmpty()) {
//             for (int i = 0; i < priorities.length; i++) {
//                 // priorities[i] = 2, 1, 3, 2
//                 // pq = 3, 2, 2, 1 / pq.peek() = 3
//                 if (priorities[i] == pq.peek()) {
//                     // 해당 priorities 기준,
//                     // i가 2일 때, 3과 3이 일치해 해당 반복문으로 빠짐

//                     // i = 2, location = 2
//                     // 즉, 가장 우선순위가 높은 애의, 기존 배열에서의 인덱스와
//                     // 문제에서 찾으라고 하는 인덱스를 구했음
//                     if (i == location) {
//                         answer ++; // 바로 1 리턴하면 되니, 1 더해준 뒤
//                         return answer; // return
//                     }

//                     // 값은 같지만, location과 index가 다름
//                     // 즉, 숫자만 같고 찾는 위치는 아니였던 것
//                     pq.poll(); // poll로 우선순위 다음으로 넘기고 지운 뒤,
//                     answer ++; // answer 증가
//                 }
//             }
//         }

//         return answer;
//     }
// }