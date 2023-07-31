// https://www.acmicpc.net/problem/2581
// 2581 소수

package baekjoon;

import java.util.Scanner;

public class Main5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = num1; i <= num2; i++) {
			if (isPrime(i)) {
				sum += i;
				if (min == Integer.MAX_VALUE) {
					min = i;
				}
			}
		}

		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

	public static boolean isPrime(int n) {
		if (n == 1)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}
}