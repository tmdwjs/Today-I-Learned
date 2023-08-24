package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 점화식
        for (int i = 0; i < n; i++) {
            // 일 시작 후 일하는 동안 퇴사일이 안 넘는다면
            if (i + t[i] <= n) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}
