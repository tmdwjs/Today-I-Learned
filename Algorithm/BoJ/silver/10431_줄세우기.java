// https://www.acmicpc.net/problem/10431

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 줄세우기_10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int cnt = 0;
            int[] arr = new int[21];

            for (int j = 0; j < 21; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j < 21; j++) {
                for (int k = 1; k < j; k++) {
                    if (arr[j] < arr[k]) cnt ++;
                }
            }

            System.out.println(i + " " + cnt);
        }
    }
}
