package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_야구_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] tc = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            tc[i][0] = Integer.parseInt(st.nextToken()); // 숫자
            tc[i][1] = Integer.parseInt(st.nextToken()); // 스트라이크
            tc[i][2] = Integer.parseInt(st.nextToken()); // 볼
        }

        int ans = 0;

        // 3개의 숫자는 최소 123부터 시작해 987 내에 있기 때문
        for (int i = 123; i <= 987; i++) {
            String cur_num = Integer.toString(i);

            // 그냥 건너뛰는 경우
            if (cur_num.charAt(0) == cur_num.charAt(1) || cur_num.charAt(1) == cur_num.charAt(2) || cur_num.charAt(0) == cur_num.charAt(2)
            || cur_num.charAt(0) == '0' || cur_num.charAt(1) == '0' || cur_num.charAt(2) == '0') {
                continue;
            }

            boolean isValid = true;

            // tc n만큼 돌며 비교
            for (int j = 0; j < n; j++) {
                String tc_num = Integer.toString(tc[j][0]);

                int cur_strike = 0;
                int cur_ball = 0;

                // 스트라이크 계산
                for (int k = 0; k < tc_num.length(); k++) {
                    if (tc_num.charAt(k) == cur_num.charAt(k)) cur_strike ++;
                }

                // 볼 계산
                for (int k = 0; k < tc_num.length(); k++) {
                    for (int l = 0; l < tc_num.length(); l++) {
                        if (k != l && tc_num.charAt(k) == cur_num.charAt(l)) {
                            cur_ball ++;
                        }
                    }
                }

                if (cur_strike != tc[j][1] || cur_ball != tc[j][2]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) ans++;

        }

        System.out.println(ans);
    }
}
