// https://www.acmicpc.net/problem/10815

package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자_카드 {
	static int N; // N 
	static int[] arr1; // 배열 1
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr1 = new int[N];
		for (int i = 0; i < N; i++) arr1[i] = sc.nextInt();
		
		Arrays.sort(arr1); // 이진탐색을 위한 오름차순

		int M = sc.nextInt(); // M 
		int[] ans = new int[M]; // 정답

		for (int i = 0; i < M; i++) {
			int num = sc.nextInt(); // M만큼 받을 숫자
			
			// 이진 탐색 메서드에 인자로 넣어준 뒤,
			if (binarySearch(num)) 
				ans[i] = 1; // 1 
			else 
				ans[i] = 0; // 0
		}
		
		// 정답 출력
		for (int el: ans) {
			System.out.print(el + " ");
		}
		
		
	}

	// 이진 탐색 메서드
	private static boolean binarySearch(int num) {
		int leftIndex = 0;
		int rightIndex = N - 1;

		while (leftIndex <= rightIndex) {
			int midIndex = (leftIndex + rightIndex) / 2;
			int mid = arr1[midIndex];

			if (num < mid)
				rightIndex = midIndex - 1;
			else if (num > mid)
				leftIndex = midIndex + 1;
			else
				return true;
		}
		return false;
	}
}
