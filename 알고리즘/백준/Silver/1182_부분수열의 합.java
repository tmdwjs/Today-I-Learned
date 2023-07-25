// https://www.acmicpc.net/problem/1182

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의_합_1182 {
    private static int n;
    private static int s;
    private static int[] arr;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int i, int cnt) {
        if (i == n) return;
        else if (arr[i] + cnt == s) ans ++;

       dfs(i + 1, cnt);
       dfs(i + 1, cnt + arr[i]);
    }
}
