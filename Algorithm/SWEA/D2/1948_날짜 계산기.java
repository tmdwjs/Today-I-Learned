// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PnnU6AOsDFAUq&categoryId=AV5PnnU6AOsDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

package swea.d2;

import java.util.Scanner;

public class Main13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
		
		for(int TC = 1; TC <= T; TC++) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			
			int ans = (days[m2-1] + d2) - (days[m1-1] + d1) + 1;
			
			System.out.println("#" + TC + " " + ans);
		}
	}
}
