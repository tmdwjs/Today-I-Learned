// https://www.acmicpc.net/problem/14494

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다이나믹이_뭐예요_14494 {
    static long[][] dp;

    public static long dp (int n, int m) {
        if (n == 0 || m == 0) return 0;
        if (n == 1 && m == 1) return 1;
        if (dp[n][m] != -1) return dp[n][m];

        long res = (dp(n, m - 1) + dp(n - 1, m) + dp(n - 1, m - 1)) % 1000000007;
        dp[n][m] = res;
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dp(n, m));
    }
}
