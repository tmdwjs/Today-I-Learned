// https://www.acmicpc.net/problem/19637

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IF문_좀_대신_써줘_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] title = new String[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            title[i][0] = st.nextToken();
            title[i][1] = st.nextToken();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int cur_power = Integer.parseInt(br.readLine());

            int left = 0;
            int right = n - 1;
            int mid;

            while (left <= right) {
                mid = (left + right) / 2;

                int power = Integer.parseInt(title[mid][1]);

                if (power < cur_power) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append(title[left][0]).append("\n");
        }

        System.out.println(sb);
    }
}
