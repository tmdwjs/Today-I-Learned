// https://www.acmicpc.net/problem/1515

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수_이어_쓰기_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = 0;

        while (true) {
            N++;                                        // 숫자를 올려가며 최솟값 N 찾기

            String cur = Integer.toString(N);

            while (str.length() > 0 && cur.length() > 0) {
                if (str.charAt(0) == cur.charAt(0)) {   // 입력 숫자의 첫 번째와 현재 증감하는 숫자의 첫 번째가 같다면
                    str = str.substring(1);             // 입력 받은 숫자의 다음 단계를 비교하기 위해 이동
                }
                cur = cur.substring(1);                 // 증가하는 숫자도 다음 단계로 이동
            }

            if (str.equals("")) {                       // str이 끝까지 갔다면(종료)
                System.out.println(N);
                break;
            }
        }
    }
}
