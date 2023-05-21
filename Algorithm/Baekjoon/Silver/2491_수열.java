// https://www.acmicpc.net/problem/2491

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;
        int plus = 0;
        int plusCount = 1;
        int minus = 0;
        int minusCount = 1;
        int prev = Integer.parseInt(st.nextToken());

        if (n == 1) {
            answer = 1;
        } else {
            for (int i = 1; i < n; i++) {
                int cur = Integer.parseInt(st.nextToken());

                // 증가할 때
                if (prev <= cur) {
                    plusCount += 1;
                    plus = Math.max(plus, plusCount);
                } else {
                    plusCount = 1; // 연속되지 않는 순간 count 초기화
                }

                // 감소할 때
                if (prev >= cur) {
                    minusCount += 1;
                    minus = Math.max(minus, minusCount);
                } else {
                    minusCount = 1; // 연속되지 않는 순간 count 초기화
                }

                prev = cur;
            }

            answer = Math.max(plus, minus);
        }

        System.out.println(answer);
    }
}
