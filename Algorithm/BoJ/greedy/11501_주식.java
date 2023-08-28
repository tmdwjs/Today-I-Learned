// https://www.acmicpc.net/problem/11501

package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] stock = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            long count = 0;

            for (int j = n - 1; j >= 0; j--) {
                if (stock[j] > max) {
                    max = stock[j];
                } else {
                    count += max - stock[j];
                }
            }

            sb.append(count + "\n");
        }

        System.out.println(sb.toString());
    }
}
