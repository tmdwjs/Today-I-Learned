// https://www.acmicpc.net/problem/1712
// 1712 손익분기점

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 1000 70 170 > 11
			// 2100000000 9 10 > 2100000001
			int fixed = Integer.parseInt(st.nextToken()); // 1000
			int variable = Integer.parseInt(st.nextToken()); // 70
			int price = Integer.parseInt(st.nextToken()); // 170
			
			if(variable >= price) {
				System.out.println(-1);
			}else {
				System.out.println((fixed/(price-variable)) + 1);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}