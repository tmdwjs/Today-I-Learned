// https://www.acmicpc.net/problem/1919

package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 에너그램_만들기_1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();

        int[] word1_arr = new int[26];
        int[] word2_arr = new int[26];
        int count = 0;

        for (char ch1: word1) word1_arr[ch1 - 97]++;
        for (char ch2: word2) word2_arr[ch2 - 97]++;

        for (int i = 0; i < 26; i++) {
            if (word1_arr[i] != word2_arr[i]) {
                count += Math.abs(word1_arr[i] - word2_arr[i]);
            }
        }

        System.out.println(count);
    }
}
