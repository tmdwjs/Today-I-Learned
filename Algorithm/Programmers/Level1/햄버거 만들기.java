// https://school.programmers.co.kr/learn/courses/30/lessons/133502

package programmers.level1;

import java.util.Stack;

public class 햄버거_만들기 {
    public static void main(String[] args) {
        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        System.out.println(solution(ingredient));
    }

    public static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int el: ingredient) {
            stack.push(el);

            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 4) == 1
                        && stack.get(stack.size() - 3) == 2
                        && stack.get(stack.size() - 2) == 3
                        && stack.get(stack.size() - 1) == 1
                ) {
                    answer ++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }

        return answer;
    }
}
