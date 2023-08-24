// https://www.acmicpc.net/problem/3986

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 좋은단어_3986 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine(); // s를 입력 받아
            checkWord(s); // s를 인자로 담아 단어 체크 메서드 실행
        }

        System.out.println(count);
    }

    public static void checkWord(String s) {
        // 홀수면 early return
        if (s.length() % 2 != 0) return;

        // stack 선언
        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0)); // 우선 첫 단어 stack에 push

        for (int i = 1; i < s.length(); i++){
            if (stack.size() > 0 && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                // 만약 i가 1일 때부터 같은 거라면,
                // 두 번째부턴 해당 조건문으로 빠지는 것

                stack.push(s.charAt(i));
            }
        }

        if (stack.isEmpty()) {
            count ++;
        }
    }
}
