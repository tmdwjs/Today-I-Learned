// https://www.acmicpc.net/problem/18110

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class solved_ac_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int ex = (int) Math.round(n * 0.15);
        double sum = 0;

        for (int i = ex; i < n - ex; i++) {
            sum += arr[i];
        }

        System.out.println(Math.round(sum / (n - (2 * ex))));
    }
}
