// https://www.acmicpc.net/problem/2960

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에라토스테네스의_체_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(era(n, k));
    }

    public static int era(int n, int k) {
        int ans = 0;
        int[] arr = new int[n + 1];

        for (int i = 2; i <= n; i++) arr[i] = 1;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) continue;

            for (int j = i; j <= n; j += i) {
                if (arr[j] == 0) continue;

                arr[j] = 0;
                k--;

                if (k == 0) ans = j;
            }
        }

        return ans;
    }
}
