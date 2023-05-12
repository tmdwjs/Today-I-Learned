// https://www.acmicpc.net/problem/14916

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        while (n > 0) {
            if (n % 5 == 0) {
                answer = n / 5 + answer;
                break;
            }

            n -= 2;
            answer ++;
        }

        answer = n < 0 ? -1 : answer;

        System.out.println(answer);
    }
}
