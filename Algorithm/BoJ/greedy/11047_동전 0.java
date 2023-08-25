// https://www.acmicpc.net/problem/11047

package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_0_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (coins[i] <= k) {
                cnt += k / coins[i];
                k %= coins[i];
            }
        }

        System.out.println(cnt);
    }
}
