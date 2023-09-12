// https://www.acmicpc.net/problem/25757

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 임스와_함께하는_미니게임_25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        switch (game) {
            case "Y":
                System.out.println(set.size());
                break;

            case "F":
                System.out.println((set.size() / 2));
                break;

            default:
                System.out.println((set.size()) / 3);
        }
    }
}
