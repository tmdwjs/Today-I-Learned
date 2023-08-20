// https://www.acmicpc.net/problem/10808

package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳_개수_10808 {
    private static int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();

        for (char c: charArr) {
            arr[(int)c - 97]++;
        }

        for (int el: arr) {
            System.out.print(el + " ");
        }
    }
}
