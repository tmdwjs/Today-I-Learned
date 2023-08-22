// https://www.acmicpc.net/problem/1789

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long m = Long.parseLong(br.readLine());
		long i = 0;
		long sum = 0;
		
		while (true) {
			if (sum > m) break;
			
			i++;
			sum += i;
		}
		
		System.out.println(i - 1);
		
	}
}
