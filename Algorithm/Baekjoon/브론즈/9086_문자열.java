// https://www.acmicpc.net/problem/9086

package baekjoon.bronze;

import java.util.Scanner;

public class Main19 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		while(sc.hasNext()) {
			String str = sc.nextLine();
			String ans = "";
			
			if(str.length() == 1) {
				ans = str + str;
			} else if(str.length() == 2) {
				ans = str;
			}else {
				ans = str.substring(0, 1) + str.substring(str.length()-1);
			}
			
			
			System.out.println(ans);
		}
	}
}
