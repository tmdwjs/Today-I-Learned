// https://www.acmicpc.net/problem/2512

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr); // 이분 탐색을 위해 오름차순

        int m = Integer.parseInt(br.readLine());

        int ans = 0;
        int left = 0;
        int right = arr[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2; // 예산 중간값
            int sum = 0;

            for (int money: arr) {
                // 금액이 중간값의 금액보다 크면 중간 금액을 더해주고,
                if (money >= mid) sum += mid;
                // 아니면 금액을 그대로 더해줌
                else sum += money;
            }

            // 금액들을 더한 값이, 예산보다 크면 right를 줄여가고
            if (sum > m) {
                right = mid - 1;

            // 작거나 같으면 left를 증가시키며 최대 금액을 찾으면서
            // answer에 최대값을 할당
            } else {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
        }

        System.out.println(ans);
    }
}
