// https://school.programmers.co.kr/learn/courses/30/lessons/154539

package programmers.level2;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {
    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};

        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {

            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.println(Arrays.toString(answer));
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
