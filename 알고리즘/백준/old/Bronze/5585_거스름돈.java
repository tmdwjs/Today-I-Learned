// https://www.acmicpc.net/problem/5585

package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int changes = 1000 - n;
        int answer = 0;

        while (changes > 0) {
            if (changes >= 500) {
                changes -= 500;
                answer ++;
            } else if (changes >= 100 && changes < 500) {
                changes -= 100;
                answer ++;
            } else if (changes >= 50 && changes < 100) {
                changes -= 50;
                answer ++;
            } else if (changes >= 10 && changes < 50) {
                changes -= 10;
                answer ++;
            } else if (changes >= 5 && changes < 10) {
                changes -= 5;
                answer ++;
            } else {
                changes -= 1;
                answer ++;
            }
        }

        System.out.println(answer);
    }
}
