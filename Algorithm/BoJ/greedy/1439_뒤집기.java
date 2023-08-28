// https://www.acmicpc.net/problem/1439

package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 뒤집기_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st1 = new StringTokenizer(s, "0"); // 0으로 split 하니 토큰 1의 개수를 구할 수 있음
        StringTokenizer st0 = new StringTokenizer(s, "1"); // 1로 split 하니 토큰 0의 개수를 구할 수 있음

        System.out.println(Math.min(st1.countTokens(), st0.countTokens()));
    }
}
