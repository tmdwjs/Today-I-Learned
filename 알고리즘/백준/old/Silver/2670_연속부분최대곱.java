// 1차 풀이(정답 확인)
// package baekjoon.silver;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// public class 연속부분최대곱_2670 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         double[] arr = new double[n + 1];
//         double[] dp = new double[n + 1];
//         double max = 0;

//         for (int i = 1; i <= n; i++) {
//             arr[i] = Double.parseDouble(br.readLine());
//             dp[i] = Math.max(arr[i], dp[i - 1] * arr[i]);
//             max = Math.max(max, dp[i]);
//         }

//         System.out.print(String.format("%.3f", max));
//     }
// }

// 2차 풀이(복습)
package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속부분최대곱_2670_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n + 1];
        double[] dp = new double[n + 1];
        double max = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
            dp[i] = Math.max(arr[i], dp[i - 1] * arr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(String.format("%.3f", max));
    }
}
