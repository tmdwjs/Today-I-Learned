// 여전히 이해 안 감..
// 나중에 다시 도전
// https://school.programmers.co.kr/learn/courses/30/lessons/178870

package programmers.level2;

import java.util.Arrays;

public class 연속된_부분_수열의_합 {
    public static void main(String[] args) {
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        System.out.println(Arrays.toString(solution(sequence, k)));
    }

    public static int[] solution(int[] sequence, int k) {
        int len = sequence.length; // 수열 길이
        int left = 0; // 시작
        int right = len; // 오른쪽
        int sum = 0; // 합

        // 0부터 수열 길이까지 반복문
        // 0부터 7
        for (int i = 0, j = 0; i < len; i++) {
            // 그냥 수열 배열의 길이와 누적합이 k만큼 반복문 돌리면서 합하고
            while (j < len && sum < k) {
                sum += sequence[j++];
                System.out.println("while문");
                System.out.println("sum: " + sum + " j: " + j );
            }

            // 만약 sum == 7이라면
            // 하지만 테스트 케이스 1번에선 sum이 10이라 여기로 안 빠짐
            if (sum == k) {
                // 범위 = count - i - 1;
                int range = j - i - 1;
                System.out.println("i: " + i + " j: " + j);
                System.out.println("range: " + range);

                if (right - left > range) {
                    System.out.println("right: " + right + " left: " + left);
                    left = i;
                    right = j - 1;
                }
            }

            // 그 외엔 sum이 대부분 k보다 큰 상태로 반복문을 탈출할 테니
            // 수열 배열의 0번째 index부터 빼 가면서 k와 같은 지점을 맞춰가기
            sum -= sequence[i];
            System.out.println("마지막");
            System.out.println("sum: " + sum + " sequence[i]: " + sequence[i]);
        }

        int[] answer = {left, right};
        System.out.println("answer");
        System.out.println("answer: " + answer);
        return answer;
    }
}
