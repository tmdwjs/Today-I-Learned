// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PwGK6AcIDFAUq&categoryId=AV5PwGK6AcIDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

package swea.d2;

import java.util.Arrays;
import java.util.Scanner;

public class Main10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t, n, k, a, b, c;
		String[] grades = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
		
		t = sc.nextInt();
		
		for(int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			
			double[] scores = new double[n];
			double sum = 0;
			
			for(int i = 0; i < n; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				
				sum = (a * 0.35) + (b * 0.45) + (c * 0.2);
				scores[i] = sum;
			}
			
			String ans = "";
			double find = scores[k-1];
			Arrays.sort(scores);
			
			for(int i = 0; i < n; i++) {
				if(find == scores[i]) {
					ans = grades[i/(n/10)];
				}
			}
			
			System.out.println("#" + tc + " " + ans);
			
		}
	}
}
