// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PpoFaAS4DFAUq&categoryId=AV5PpoFaAS4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

package swea.d2;

import java.util.Scanner;

public class Main12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t, n, m, max;
		int[] a, b;
		t = sc.nextInt();

		// 테스트 케이스
		for (int tc = 1; tc <= t; tc++) {
			// 변수 및 배열 생성
			n = sc.nextInt(); // 3
			m = sc.nextInt(); // 5
			a = new int[n]; // a 배열
			b = new int[m]; // b 배열
			for (int i = 0; i < a.length; i++)
				a[i] = sc.nextInt(); // [1, 5, 3]
			for (int i = 0; i < b.length; i++)
				b[i] = sc.nextInt(); // [3, 6, -7, 5, 4]
			max = 0; // tc의 최대값

			// a 배열보다 b 배열이 클 때
			if (n < m) {
				// 최종적으로 돌 반복문
				for (int i = 0; i < m - n + 1; i++) {
					int sum = 0; // 작은 배열 기준으로 돌 때마다 합 체크

					// 작은 배열 기준으로 돌 반복문
					for (int j = 0; j < n; j++) {
						sum += a[j] * b[i + j]; // b 배열(더 긴 배열)은 한 칸씩(i만큼) 밀림
					}

					max = Math.max(max, sum); // 한 바퀴 돌 때마다 max 업데이트
				}
			}

			// a 배열보다 b 배열이 작을 때
			if (n > m) {
				// 최종적으로 돌 반복문
				for (int i = 0; i < n - m + 1; i++) {
					int sum = 0; // 작은 배열 기준으로 돌 때마다 합 체크

					// 작은 배열 기준으로 돌 반복문
					for (int j = 0; j < m; j++) {
						sum += a[i + j] * b[j]; // a 배열(더 긴 배열)은 한 칸씩(i만큼) 밀림
					}

					max = Math.max(max, sum); // 한 바퀴 돌 때마다 max 업데이트
				}
			}
			
			// a 배열과 b 배열이 같을 때
			if (n == m) {
				int sum = 0;
				
				for(int i = 0; i < n; i++) {
					sum += a[i] * b[i];
				}
				
				max = Math.max(max, sum);
			}

			System.out.println("#" + tc + " " + max);
		}
	}
}
