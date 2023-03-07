// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PrmyKAWEDFAUq&categoryId=AV5PrmyKAWEDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2&&&&&&&&&&

package swea.d2;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			
			// 정수 배열 생성
			int[] arr = new int[N];
			
			// 반복문 돌린 후 배열에 담아
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}
			
			// 정렬
			Arrays.sort(arr);
			
			String str = "";
			
			for(int k = 0; k < N; k++) {
				str += arr[k] + " ";
			}
			
			System.out.println("#" + (i + 1) + " " + str);
		}
	}
}