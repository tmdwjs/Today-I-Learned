// https://www.acmicpc.net/problem/2440

package baekjoon.bronze;

import java.util.Scanner;

public class Main17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = T; i >= 1; i--) {
			String res = "";
			int N = i;
			
			for(int j = 1; j <= N; j++) {
				res += "*";
			}
			
			System.out.println(res);
		}
		
		
	}
}
