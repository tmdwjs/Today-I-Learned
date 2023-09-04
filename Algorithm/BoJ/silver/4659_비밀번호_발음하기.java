// https://www.acmicpc.net/problem/4659

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 비밀번호_발음하기_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String pw = br.readLine();

            if (pw.equals("end")) break;

            String ans = "is not acceptable";


            // 조건 1. 모음(a, e, i, o, u) 하나를 반드시 포함해야 한다.
            if (
                    pw.contains("a")
                    || pw.contains("e")
                    || pw.contains("i")
                    || pw.contains("o")
                    || pw.contains("u")
            ) {

                // 조건 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
                if (check1(pw)) {
                    // 조건 3. 같은 글자가 연속적으로 두 번 오면 안 되나, ee와 oo는 허용한다.
                    if (check2(pw)) {
                        // 조건 세 개 모두 부합 시, 출력 메시지를 새로 할당한다.
                        ans = "is acceptable";
                    }
                }
            }

            System.out.println("<" + pw + "> " + ans + ".");
        }
    }

    // 조건 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
    public static boolean check1(String str) {
        boolean res = true;
        int cntC = 0;
        int cntV = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            switch (c) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    cntV++; // a e i o u일 때 카운트
                    cntC = 0; // 연속된 것을 체크하는 것이니, 자음 카운트는 초기화
                    break;
                default:
                    cntC++; // 자음일 때 카운트
                    cntV = 0; // 연속된 것을 체크하는 것이니, 모음 카운트는 초기화
                    break;
            }

            // 3개 이상 연속된 글자가 나오는 순간, 다시 스위칭 돼 0으로 초기화 되지 않게 바로 반복문 종료
            if (cntC == 3 || cntV == 3) break;
        }

        if (cntC >= 3 || cntV >= 3) res = false;

        return res;
    }

    // 조건 3. 같은 글자가 연속적으로 두 번 오면 안 되나, ee와 oo는 허용한다.
    public static boolean check2(String str) {
        boolean res = true;

        for (int i = 1; i < str.length(); i++) {
            char c1 = str.charAt(i - 1);
            char c2 = str.charAt(i);

            if ((c1 == c2)) {
                if ((c1 != 'e') && (c1 != 'o')) {
                    res = false;
                }
            }
        }

        return res;
    }
}
