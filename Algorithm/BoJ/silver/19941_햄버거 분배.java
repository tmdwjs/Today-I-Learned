// https://www.acmicpc.net/problem/19941

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거_분배_19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 20
        int k = Integer.parseInt(st.nextToken()); // 1

        String input = br.readLine(); // HHPHPPHHPPHPPPHPHPHP
        char[] table = new char[n]; // [H, H, P, H, P, P, H, H, P, P, H, P, P, P, H, P, H, P, H, P]
        for (int i = 0; i < n; i++) {
            table[i] = input.charAt(i);
        }

        int ans = 0; // 답
        boolean[] ate = new boolean[n];

        // 테이블을 돌면서,
        for (int i = 0; i < n; i++) {
            // 만약 사람이라면,
            if (table[i] == 'P') {
                int start = Math.max(0, i - k); // 0(처음)과, 현재 인덱스에서 k만큼 이전 중 더 큰 것부터 시작 지점으로 설정
                int end = Math.min(i + k, n - 1); // 현재 인덱스에서 k만큼 이후와 맨 마지막과 비교해 끝 지점으로 설정

                // 현재 인덱스에서 k만큼 이전부터 k만큼 이후까지 반복문 돌면서
                for (int j = start; j <= end; j++) {
                    // 햄버거면서, 방문하지 않은(사람에게 배정되지 않은) 햄버거라면
                    if (table[j] == 'H' && !ate[j]) {
                        ate[j] = true;
                        ans++;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
