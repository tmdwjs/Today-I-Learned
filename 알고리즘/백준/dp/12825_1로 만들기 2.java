// https://www.acmicpc.net/problem/12852

package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로_만들기_2_12825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] history = new int[n + 1];

        dp[0] = dp[1] = 0;
        history[0] = 0; history[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            history[i] = i - 1;

            if (i % 2 == 0 && (dp[i] > dp[i / 2] + 1)) {
                dp[i] = dp[i / 2] + 1;
                history[i] = i / 2;
            }

            if (i % 3 == 0 && (dp[i] > dp[i / 3] + 1)) {
                dp[i] = dp[i / 3] + 1;
                history[i] = i / 3;
            }
        }

        System.out.println(dp[n]);

        int cur = n;

        while (true) {
            System.out.print(cur + " ");
            if (cur == 1) break;
            cur = history[cur];
        }
    }
}
