// https://www.acmicpc.net/problem/11328

package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stryfry_11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] word1 = st.nextToken().toCharArray();
            char[] word2 = st.nextToken().toCharArray();
            int[] alpha = new int[26];

            for (char c1: word1) alpha[c1 - 97]++;
            for (char c2: word2) alpha[c2 - 97]--;

            String answer = "Possible";

            for (int el: alpha) {
                if (el != 0) {
                    answer = "Impossible";
                    break;
                }
            }

            System.out.println(answer);
        }
    }
}
