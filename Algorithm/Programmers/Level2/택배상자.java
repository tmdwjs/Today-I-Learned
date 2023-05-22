// 통과용 풀이
// 다른 풀이로 다시 풀어볼 예정
// https://school.programmers.co.kr/learn/courses/30/lessons/131704

package programmers.level2;

import java.util.Stack;

public class 택배상자 {
    public static void main(String[] args) {
        int[] order = {5, 4, 3, 2, 1};
        System.out.println(solution(order));
    }

    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        int defaultOrder = 1; // 1, 2, 3 등 디폴트 순서
        int orderIdx = 0; // 희망하는 주문 순서

        while (true) {
            if (!stack.isEmpty() && order[orderIdx] == stack.peek()) {
                answer ++;
                orderIdx ++;
                stack.pop();

                continue;
            }

            if (defaultOrder > order.length) break;

            if (order[orderIdx] == defaultOrder) {
                answer ++;
                orderIdx ++;
                defaultOrder ++;

                continue;
            }

            stack.push(defaultOrder);
            defaultOrder ++;
        }

        return answer;
    }
}
