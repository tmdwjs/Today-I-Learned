// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV189xUaI8UCFAZN&categoryId=AV189xUaI8UCFAZN&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=3#;return%20false;

package swea.d2;

import java.util.Scanner;

public class Main14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int TC = 1; TC <= T; TC++) {
			int P = sc.nextInt(); // 1L 당 P만 원
			int Q = sc.nextInt(); // Q만 원 선불
			int R = sc.nextInt(); // RL 이하까지 Q 가격
			int S = sc.nextInt(); // 1L 당 S만 원
			int W = sc.nextInt(); // 가구 사용량

			// 이후 A사와 B사 구해서 Math.min으로 출력
			// 8 300 100 10 250
			// A사: 8 * 250 = 2000
			// B사: 300 + (250 - 100) * 10 = 1800
			// A사 공식: P * W
			// B사 공식: Q || Q + (W - R) * S

			int A = P * W;
			int B = Q;
			
			if (R < W)
				B = Q + (W - R) * S;

			int ANS = A < B ? A : B;

			System.out.println("#" + TC + " " + ANS);
		}
	}
}
