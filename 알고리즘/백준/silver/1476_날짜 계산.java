// https://www.acmicpc.net/problem/1476

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짜_계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int earth = 0;
		int sun = 0;
		int moon = 0;
		int year = 0;
		
		while (true) {
			year ++;
			earth ++;
			sun ++;
			moon ++;
			
			if (earth == 16) earth = 1;
			if (sun == 29) sun = 1;
			if (moon == 20) moon = 1;
			if (earth == E && sun == S && moon == M) break;
		}
		
		System.out.println(year);
		
	}
}