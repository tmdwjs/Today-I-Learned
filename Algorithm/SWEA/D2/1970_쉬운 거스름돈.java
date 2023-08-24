// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PsIl6AXIDFAUq&categoryId=AV5PsIl6AXIDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

package swea.d2;

import java.util.Scanner;

public class Main8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		
		int T = sc.nextInt();
		int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr2 = {0, 0, 0, 0, 0, 0, 0, 0};
			sb = new StringBuilder();
			
			for(int i = 0; i < arr.length; i++) {
				while(N >= arr[i]) {
					N -= arr[i];
					arr2[i] ++;
				}
			}
			
			for(int el: arr2) {
				sb.append(el).append(" ");
			}
			
			System.out.println("#" + tc);
			System.out.println(sb);
		}
		
		
	}
}