// https://www.acmicpc.net/problem/2530

package baekjoon.bronze;

import java.util.Scanner;

public class Main18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int n = sc.nextInt();

		m += n / 60;
		s += n % 60;

		m += s / 60;
		s %= 60;
		
		h += m / 60;
		m %= 60;
		
		h %= 24;
			
		System.out.println(h + " " + m + " " + s);
	}
}
