// https://www.acmicpc.net/problem/10826

package baekjoon.silver;

import java.io.*;
import java.math.BigInteger;

public class 피보나치_수_4_10826 {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt((br.readLine()));

        // 2. 로직
        BigInteger[] dp = new BigInteger[n + 2];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2].add(dp[i - 1]);
        }

        // 3. 출력
        bw.write(String.valueOf(dp[n]));
        bw.flush();
        br.close();
        bw.close();
    }
}
