// https://www.acmicpc.net/submit/9076
// 9076 점수 집계

package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] score = new int[5];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < score.length; j++) {
				score[j] = sc.nextInt();
			}
			Arrays.sort(score);
			
			if(score[3] - score[1] >= 4) {
				System.out.println("KIN");
			}else {
				System.out.println(score[1] + score[2] + score[3]);
			}
		}

	}
}