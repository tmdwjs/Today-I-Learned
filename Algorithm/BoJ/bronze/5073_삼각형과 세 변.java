// https://www.acmicpc.net/submit/5073

package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 삼각형과_세_변_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[3];

        while (true) {
            st = new StringTokenizer(br.readLine());

            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            // 전부 0이면 반복문 종료
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;

            // 오름차순
            Arrays.sort(arr);

            // 삼각형 조건 불충족 시 Invalid
            if (arr[0] + arr[1] <= arr[2]) {
                System.out.println("Invalid");

            // 삼각형 조건 충족 시
            } else {
                // 세 변이 전부 같은 경우
                if (arr[0] == arr[1] && arr[1] == arr[2]) {
                    System.out.println("Equilateral");

                // 세 변이 전부 다른 경우
                } else if (arr[0] != arr[1] && arr[1] != arr[2]) {
                    System.out.println("Scalene");

                // 그 외
                } else {
                    System.out.println("Isosceles");
                }
            }
        }
    }
}
