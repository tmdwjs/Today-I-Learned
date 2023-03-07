// https://www.acmicpc.net/problem/1010
// 1010 다리 놓기

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13 {
	static int[][] arr = new int[30][30]; 	// 최대 입력 29
											// bridges method 내에서 배열 선언 시 시간 초과
											// 전역 static으로 잡아줘야 함

	public static void main(String[] args) throws IOException {
		//  Scanner로 입력을 받을 시 시간 초과
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 반복 횟수

		StringTokenizer st;	// StringTokenizer를 사용해 공백 기준 문자열 split
		StringBuilder sb = new StringBuilder();	// 반복문을 돌 때마다 출력 시, 시간 초과 발생
												// StringBuilder를 사용해 출력할 답을 더해 최종적으로 한 번에 return 할 것
												// 더할 땐 append() method를 사용해 합치면 됨

		// 반복 횟수만큼 반복문 실행
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(bridges(M, N)).append("\n");
		}

		System.out.println(sb);
	}

	// 조합 공식
	static int bridges(int n, int r) {

		// 이미 풀린 경우 바로 return 
		if (arr[n][r] > 0) {
			return arr[n][r];
		}

		// 2번 성질
		// nCn = nC0 = 1
		if (n == r || r == 0) {
			return arr[n][r] = 1;
		}

		// 1번 성질
		// 점화식
		// n+1Cr+1 = nCr + nCr+1
		return arr[n][r] = bridges(n - 1, r - 1) + bridges(n - 1, r);
	}
}