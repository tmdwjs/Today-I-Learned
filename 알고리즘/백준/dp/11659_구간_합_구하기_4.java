// https://www.acmicpc.net/problem/11659

package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기_4_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 1];
        dp[0] = 0;

        int s, e;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            System.out.println(dp[e] - dp[s - 1]);
        }
    }
}
