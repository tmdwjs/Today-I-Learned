// https://school.programmers.co.kr/learn/courses/30/lessons/155652

package programmers.level1;

import java.util.StringTokenizer;

public class 둘만의_암호 {
    public static void main(String[] args) {
        String s = "zzzzz";
        String skip = "a";
        int index = 1;
        System.out.println(solution(s, skip, index));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // 현재 문자

            // index만큰 반복문 한 번 더 돌면서,
            for (int j = 0; j < index; j++) {
                c ++; // 증가

                // z를 넘으면 다시 a로
                if (c > 'z') c -= 26;

                // 식별 후, skip에 포함돼 있으면,
                // 그만큼 더 돌아야 하니 j --
                if (skip.contains(String.valueOf(c))) j --;

                // 먼저 z -> a 처리를 해 주는 이유
                // z -> a부터 먼저 해준 뒤,
                // skip에 포함 여부를 알아야 j를 더 줄지 말지 결정할 수 있어서
                // 그래야 테케 'zzzzz', 'a', 1 통과 가능
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
