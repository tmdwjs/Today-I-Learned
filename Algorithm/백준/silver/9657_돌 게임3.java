// https://www.acmicpc.net/problem/9657

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌_게임_3_9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;

        for (int i = 5; i <= n; i++) {
            if (dp[i - 1] + dp[i - 3] + dp[i - 4] < 3) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }

        System.out.println(dp[n] == 1 ? "SK" : "CY");
    }
}
