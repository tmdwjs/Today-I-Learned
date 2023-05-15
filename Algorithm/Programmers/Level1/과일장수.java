// https://school.programmers.co.kr/learn/courses/30/lessons/135808

package programmers.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 과일장수 {
    public static void main(String[] args) {
        // 테스트케이스 2번
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        System.out.println(solution(k, m, score)); // 33
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for (int i = score.length - 1; i >= 0; i--) {
            if ((score.length - i) % m == 0) {
                answer += score[i] * m;
            }
        }

        return answer;
    }
}
