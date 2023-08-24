// https://www.acmicpc.net/problem/1074

package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(func(n, r, c));
    }

    public static int func(int n, int r, int c) {
        if (n == 0) return 0;

        int m = 1 << (n - 1);

        if (r < m && c < m) return func (n - 1, r, c);
        if (r < m && c >= m) return m * m + func (n - 1, r, c - m);
        if (r >= m && c < m) return 2 * m * m + func (n - 1, r - m, c);
        return 3 * m * m + func (n - 1, r - m, c - m);
    }
}
