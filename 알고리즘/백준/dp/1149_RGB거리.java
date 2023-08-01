// https://www.acmicpc.net/problem/1149

package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGP거리_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];
        StringTokenizer st;
        int r, g, b;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r; // dp[i][0] = r. 현재 r 자리는 안 겹치는 g, b 중 작은 수 + r
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g; // dp[i][1] = g. 현재 g 자리는 안 겹치는 r, b 중 작은 수 + g
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b; // dp[i][2] = b. 현재 b 자리는 안 겹치는 r, g 중 작은 수 + b
        }

        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }
}
