// https://www.acmicpc.net/problem/2161

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드1_2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) q.add(i);

        while (!q.isEmpty()) {
            sb.append(q.poll()).append(" ");

            if (q.isEmpty()) break;

            q.add(q.poll());
        }

        System.out.println(sb.toString());

    }
}
