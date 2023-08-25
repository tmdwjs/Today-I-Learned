// https://www.acmicpc.net/submit/15649

package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_1_15649 {
    private static int n;
    private static int m;
    private static int[] arr = new int[10];
    private static boolean[] checked = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        func(0);
    }

    public static void func(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
        }

        for (int i = 1; i <= n; i++) {
            if (!checked[i]) {
                arr[k] = i;
                checked[i] = true;
                func(k + 1);
                checked[i] = false;
            }
        }
    }
}
