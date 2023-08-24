// https://www.acmicpc.net/problem/1822

package Algorithm.백준.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 차집합_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // a 길이
        int b = Integer.parseInt(st.nextToken()); // b 길이

        // a 트리셋
        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < a; i++) tree.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            int cur_b = Integer.parseInt(st.nextToken());
            if (tree.contains(cur_b)) tree.remove(cur_b);
        }

        if (tree.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(tree.size());

            for (int el: tree) {
                System.out.print(el + " ");
            }
        }
    }
}
