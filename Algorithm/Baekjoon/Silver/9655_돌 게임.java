// https://www.acmicpc.net/submit/9655

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌_게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = (n % 2 == 0) ? "CY" : "SK";
		
		System.out.println(str);
	}
}
