// https://www.acmicpc.net/problem/1205

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등수_구하기_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        // 랭킹 리스트가 존재할 시
        if (n != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 랭킹 리스트 순위권 밖이면서 랭킹 리스트가 꽉 차 있다면
            // 순위권 밖이어도, 랭킹 리스트가 비어있으면 들어올 수 있고,
            // 순위권 안이어도, 랭킹 리스트가 다 차 있는 경우가 있음(?)
            if (arr[n - 1] >= score && n == p) {
                System.out.println(-1);

            // 랭킹 리스트 순위권 안
            } else {
                int rank = 1;

                for (int i = 0; i < n; i++) {
                    if (score < arr[i]) {
                        rank ++;
                    } else {
                        break;
                    }
                }

                System.out.println(rank);
            }

        // 랭킹 리스트가 존재하지 않을 시, 자동으로 1등
        } else {
            System.out.println(1);
        }


    }
}
