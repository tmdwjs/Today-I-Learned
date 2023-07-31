// https://www.acmicpc.net/problem/11653
// 11653 소인수분해

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int k = 2;
			
			while(num != 1) {
				if(num % k == 0) {
					System.out.println(k);
					num /= k;
				}else {
					k++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}