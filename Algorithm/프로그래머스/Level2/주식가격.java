// https://school.programmers.co.kr/learn/courses/30/lessons/42584

// package programmers.level2;

package Algorithm.프로그래머스.Level2;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i] ++;
                if (prices[i] > prices[j]) break;
            }
        }

        return answer;
    }
}

// 스택을 이용한 풀이

// import java.util.Arrays;
// import java.util.Stack;

// public class 주식가격 {
//     public static void main(String[] args) {
//         int[] prices = {1, 2, 3, 2, 3};
//         System.out.println(Arrays.toString(solution(prices)));
//     }

//     public static int[] solution(int[] prices) {
//         int[] answer = new int[prices.length];
//         Stack<Integer> stack = new Stack<>();

//         stack.push(0);

//         for (int i = 1; i < prices.length; i++) {
//             while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
//                 answer[stack.peek()] = i - stack.peek();
//                 stack.pop();
//             }

//             stack.push(i);
//         }

//         while (!stack.isEmpty()) {
//             answer[stack.peek()] = prices.length - stack.peek() - 1;
//             stack.pop();
//         }

//         return answer;
//     }
// }
