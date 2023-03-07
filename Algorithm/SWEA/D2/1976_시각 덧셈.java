// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PttaaAZIDFAUq&categoryId=AV5PttaaAZIDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

package swea.d2;

import java.util.Scanner;

public class Main11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t, h1, m1, h2, m2, h, m;
		
		t = sc.nextInt();
		
		for(int tc = 1; tc <= t; tc++) {
			h1 = sc.nextInt(); // 첫 번째 시
			m1 = sc.nextInt(); // 첫 번째 분
			h2 = sc.nextInt(); // 두 번째 시
			m2 = sc.nextInt(); // 두 번째 분
			
			h = h1 + h2; // 시 더하기
			m = m1 + m2; // 분 더하기
			
			if(m >= 60) {
				h += (m / 60);
				m = (m % 60);
			}
			if(h > 12) {
				 h -= 12; 
			}
			
			System.out.println("#" + tc + " " + h + " " + m);
		}
	}
}
