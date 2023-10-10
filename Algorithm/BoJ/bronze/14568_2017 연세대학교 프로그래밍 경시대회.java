// https://www.acmicpc.net/problem/14568

package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2017_연세대학교_프로그래밍_경시대회_14568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int candy = Integer.parseInt(br.readLine()); // 사탕 6개
        int answer = 0;

        // 택희
        for (int i = 1; i <= candy; i++) {
            // 영훈
            for (int j = 1; j <= candy; j++) {
                // 남규
                for (int k = 1; k <= candy; k++) {
                    // 조건 1. 택희 + 영훈 + 남규 = 사탕 개수
                    if (i + j + k == candy) {
                        // 조건 2. 남규는 영훈보다 2개 이상 많다
                        if (k  >= j + 2) {
                            // 조건 3. 사탕이 0개인 사람은 없음
                            if (i != 0 && j != 0 && k != 0) {
                                // 조건 4. 택희의 사탕 수는 홀수가 아니다
                                if (i % 2 == 0) {
                                    answer += 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
