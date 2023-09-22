// https://www.acmicpc.net/problem/22233

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 가희와_키워드_22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), true);
        }

        int cnt = n;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            while(st.hasMoreTokens()) {
                String s = st.nextToken();

                if (map.containsKey(s)) {
                    map.remove(s);
                    cnt--;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
