// https://www.acmicpc.net/submit/5576
// 5576 콘테스트

package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] yArr = new int[10];
		int[] kArr = new int[10];
		int ySum = 0;
		int kSum = 0;

		for (int i = 0; i < yArr.length; i++) {
			yArr[i] = sc.nextInt();
		}

		for (int j = 0; j < kArr.length; j++) {
			kArr[j] = sc.nextInt();
		}

		Arrays.sort(yArr);
		Arrays.sort(kArr);

		for (int k = yArr.length - 1; k >= yArr.length - 3; k--) {
			ySum += yArr[k];
		}
		
		for (int l = kArr.length - 1; l >= kArr.length - 3; l--) {
			kSum += kArr[l];
		}

		System.out.println(ySum + " " + kSum);
	}
}