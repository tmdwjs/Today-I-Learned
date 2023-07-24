// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5Pl0Q6ANQDFAUq&categoryId=AV5Pl0Q6ANQDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2

package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 10
		int[] arr = {2, 3, 5, 7, 11};
		
		// test case 1 ~ 10
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine()); // 정수 N들
			int[] arr2 = {0, 0, 0, 0, 0};
			
			for(int j = 0; j < arr.length; j++) {
				while(true) {
					// 계속 나눠지거나
					if(N % arr[j] == 0) {
						arr2[j]++;
						N /= arr[j];
						
					// 다 나눠지면 반복문 탈출
					}else {
						break;
					}
				}
			}

			String str = "";
			
			for(int el: arr2) {
				str += el + " ";
			}
			
			System.out.println("#" + i + " " + str);
		}
	}
}
