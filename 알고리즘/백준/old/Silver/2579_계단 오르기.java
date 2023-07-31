// 1차 top-down
// top-down 시 재귀로 풀기 위해, 메서드를 하나 더 생성
// 메서드에서 dp와 arr 배열에 접근하기 위해, dp와 arr를 static으로 생성

// package baekjoon.silver;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// public class 계단_오르기_2579 {
//     static int[] arr;
//     static Integer[] dp;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         arr = new int[n + 1];
//         dp = new Integer[n + 1];

//         for (int i = 1; i <= n; i++) {
//             arr[i] = Integer.parseInt(br.readLine());
//         }

//         // Integer 타입은 초기화 안 할 시 default 값이 null
//         dp[0] = arr[0];
//         dp[1] = arr[1];
//         if (n >= 2) { // n이 1이 입력될 수 있어 예외 처리
//             dp[2] = arr[2] + arr[1];
//         }

//         System.out.println(find(n));
//     }

//     static int find(int n) {
//         // 아직 탐색 안 한 경우
//         // n이 3부터
//         if (dp[n] == null) {
//             dp[n] = Math.max(find(n - 2), find(n - 3) + arr[n - 1]) + arr[n];
//         }

//         return dp[n];
//     }
// }










// 2차 bottom-up
// bottom-up은 for문으로 풀이

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단_오르기_2579_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];

        if (n >= 2) {
            dp[2] = arr[2] + arr[1];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(dp[n]);
    }
}
