// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PTeo6AHUDFAUq&categoryId=AV5PTeo6AHUDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			String str = Integer.toString(i);
			
			if(str.contains("3") || str.contains("6") || str.contains("9")) {
				for(int j = 0; j < str.length(); j++) {
					if(str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
						sb.append("-");
					}
				}
				
				sb.append(" ");
			}else {
				sb.append(i).append(" ");
			}
			
		}
		
		System.out.println(sb);
	}
}