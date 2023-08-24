// https://www.acmicpc.net/problem/9095

package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이삼_더하기_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n, cnt;
        int[] dp = new int[12];

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            cnt = 0;

            dp[1] = 1; dp[2] = 2; dp[3] = 4;

            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }

            System.out.println(dp[n]);
        }
    }
}
