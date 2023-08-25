// https://www.acmicpc.net/problem/2217

package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로프_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 로프의 개수
        int[] rope = new int[n];
        for (int i = 0; i < n; i++) rope[i] = Integer.parseInt(br.readLine());

        Arrays.sort(rope);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, rope[i] * (n - i));
        }

        System.out.println(max);
    }
}
