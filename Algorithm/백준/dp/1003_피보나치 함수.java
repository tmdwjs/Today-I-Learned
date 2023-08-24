// https://www.acmicpc.net/problem/1003

package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_함수_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] fibo0 = new int[41];
            int[] fibo1 = new int[41];

            fibo0[0] = 1; fibo0[1] = 0; fibo1[0] = 0; fibo1[1] = 1;

            for (int j = 2; j <= n; j++ ){
                fibo0[j] = fibo0[j - 1] + fibo0[j - 2];
                fibo1[j] = fibo1[j - 1] + fibo1[j - 2];
            }

            System.out.println(fibo0[n] + " " + fibo1[n]);
        }
    }
}
