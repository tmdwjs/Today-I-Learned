// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV2gbY0qAAQBBAS0&categoryId=AV2gbY0qAAQBBAS0&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=1&pageSize=10&pageIndex=2

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main9 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		for(int i = n; i >= 0; i--) {
			System.out.print(i + " ");
		}
	}
}
