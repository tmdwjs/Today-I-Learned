// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PxmBqAe8DFAUq&categoryId=AV5PxmBqAe8DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main3 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			
			for(int j = 1; j <= N; j++) {
				if(j % 2 != 0) {
					ans += j;
				}else {
					ans -= j;
				}
			}
			
			System.out.println("#" + (i + 1) + " " + ans);
		}
	}
}