// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5Pw_-KAdcDFAUq&categoryId=AV5Pw_-KAdcDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main6 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc = 1; tc <= T; tc++) {
			double sum = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[10];
			
			for(int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr); // 오름차순
			
			for(int j = 1; j < 9; j++) {
				sum += arr[j];
			}
			
			int ans = (int)((Math.round(sum / 8) * 10.0) / 10.0);
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
