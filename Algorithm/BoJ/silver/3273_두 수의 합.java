// https://www.acmicpc.net/status?user_id=tmdwjs&problem_id=3273&from_mine=1

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 두_수의_합_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 배열 개수
        int[] arr = new int[n]; // 배열
        HashSet<Integer> set = new HashSet<>();
        int x = 0; // 두 수의 합 변수 선언
        int cnt = 0; // 정답으로 return 될 count

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        x = Integer.parseInt(br.readLine()); // 두 수의 합 할당

        for (int i = 0; i < n; i++) {
            // hashset에 합 x - 현재 요소가 존재하면
            if (set.contains(x - arr[i])) {
                cnt ++; // 카운트
            }
        }

        System.out.println(cnt / 2); // (5, 7), (7, 5) 중복 제거 위함
    }
}
