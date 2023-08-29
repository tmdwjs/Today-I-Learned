// https://www.acmicpc.net/problem/13414

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class 수강신청_13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i < l; i++) {
            String stdId = br.readLine();
            if (set.contains(stdId)) set.remove(stdId);
            set.add(stdId);
        }

        for (String el: set) {
            if (k == 0) break;
            System.out.println(el);
            k --;
        }

    }
}
