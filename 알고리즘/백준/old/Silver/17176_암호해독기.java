// https://www.acmicpc.net/problem/17176

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 암호해독기_17176 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> code = new ArrayList<>();

        for (int i = 0; i < n; i++) code.add(Integer.parseInt(st.nextToken()));
        Collections.sort(code);

        String str = br.readLine();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            int ascii = (int)(str.charAt(i));

            if (ascii == 32) {
                list.add(0);
            } else if (ascii >= 65 && ascii <= 90) {
                list.add(ascii - 64);
            } else {
                list.add(ascii - 70);
            }
        }

        Collections.sort(list);

        int answer = 0;

        for (int i = 0; i < code.size(); i++) {
            if (code.get(i) == list.get(i)) {
                answer ++;
            }
        }

        if (answer == code.size()) {
            System.out.println("y");
        } else {
            System.out.println("n");
        }

    }
}
