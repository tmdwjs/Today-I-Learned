// https://www.acmicpc.net/problem/2607

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비슷한_단어_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String word = br.readLine();
        int ans = 0;

        int[] words = new int[26];
        for (int i = 0; i < word.length(); i++) {
            words[word.charAt(i) - 'A']++;
        }

        for (int i = 0; i < n - 1; i++) {
            // 배열을 계속 그리든지 복사하기
            int[] cpy_words = words.clone();
            String cur_word = br.readLine();
            int cnt = 0;

            for (int j = 0; j < cur_word.length(); j++) {
                if (cpy_words[cur_word.charAt(j) - 'A'] > 0) {
                    cnt ++;
                    cpy_words[cur_word.charAt(j) - 'A'] --;
                }
            }

            // 1. 문자열 길이가 같은 경우
            // 같되, 문자 모두가 같은 경우 or 문자 한 개만 다른 경우
            if (
                    word.length() == cur_word.length()
                    && (word.length() == cnt || word.length() - 1 == cnt)
            ) {
                ans ++;
            }
            // 2. 문자열 길이가 짧은 경우(제거)
            else if (
                    word.length() == cur_word.length() - 1
                    && cur_word.length() - 1 == cnt
            ) {
                ans ++;
            }
            // 3. 문자열 길이가 긴 경우(추가)
            else if (
                    word.length() == cur_word.length() + 1
                    && cur_word.length() == cnt
            ) {
                ans ++;
            }
        }

        System.out.println(ans);
    }
}
