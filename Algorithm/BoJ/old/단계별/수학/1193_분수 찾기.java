// https://www.acmicpc.net/problem/1193
// 1193 분수 찾기

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int sum = 0;
		int cur = 1;

		while (true) {
			// 받아온 수가, 현재 행의 위치와 이전 대각선들 누적합 안에 포함되면,
			if (n <= cur + sum) {
				// 해당 행의 분수 안에서 답이 도출될 것
				if (cur % 2 == 0) {
					// 짝수면 왼쪽 아래로 내려감(분자 커지고, 분모 작아짐)
					System.out.println((n - sum) + "/" + (cur - (n - (sum + 1))));
					break;
				} else {
					// 홀수면 오른쪽 위로 올라감(분자 작아지고, 분모 커짐)
					System.out.println((cur - (n - (sum + 1))) + "/" + (n - sum));
					break;
				}
			} else {
				// 위 조건에 걸리지 않으면,
				// 무조건 다음 행에서 받아온 수의 자리에 해당하는 번호를 찾을 수 있음
				// 그러니 cur(행 몇 번째)이 1씩 커지고,
				// 누적해 온 행과 더해주기
				sum += cur;
				cur++;
			}
		}

		// 1 > 1/1
		// 1 1개 = 행 위치 1
		// 여태 거쳐온 대각선 수 0
		// 즉 행 위치 + 대각선 수 = 1 + 0 = 1(까지 들어옴)

		// 2 > 1/2
		// 3 > 2/1
		// 2, 3 2개 = 행 위치 2
		// 여태 거쳐온 대각선 수 1
		// 즉 행 위치 + 대각선 수 = 2 + 1 = 3(까지 들어옴)
		// 행 위치가 짝수면 왼쪽 아래로 내려감(분자 커지고, 분모 작아짐)

		// 4 > 3/1
		// 5 > 2/2
		// 6 > 1/3
		// 4, 5, 6 3개 = 행 위치 3
		// 여태 거쳐온 대각선 수 3
		// 즉 행 위치 + 대각선 수 = 3 + 3 = 6(까지 들어옴)
		// 행 위치가 홀수면 오른쪽 위로 올라감(분자 작아지고, 분모 커짐)

		// 7 > 1/4
		// 8 > 2/3
		// 9 > 3/2
		// 10 > 4/1
		// 7, 8, 9, 10 4개 = 행 위치 4
		// 여태 거쳐온 대각선 수 6
		// 즉 행 위치 + 대각선 수 = 4 + 6 = 10(까지 들어옴)

		// 11 > 5/1
		// 12 > 4/2
		// 13 > 3/3
		// 14 > 2/4
		// 15 > 1/5
		// 11, 12, 13, 14, 15 5개 = 행 위치 5
		// 여태 거쳐온 대각선 수 10
		// 즉 행 위치 + 대각선 수 = 5 + 10 = 15(까지 들어옴)

	}
}