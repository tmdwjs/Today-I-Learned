// https://www.acmicpc.net/problem/1676

package baekjoon.silver;

import java.util.Scanner;

public class 팩토리얼_0의_개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		
		while (num >= 5) {
			count += num / 5;
			num /= 5;
		}
		
		System.out.println(count);
	}
}
