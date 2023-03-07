// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5P0-h6Ak4DFAUq&categoryId=AV5P0-h6Ak4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

package swea.d2;

import java.util.Scanner;

public class Main9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				
				for(int j = 0; j <= i; j++) {
					
					if(j == 0 || i == j) {
						arr[i][j] = 1;
					}else {
						arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
					}
				}
			}
			
			System.out.println("#" + tc);
			
			for(int k = 0; k < N; k++) {
				for( int l = 0; l <= k; l++) {
					System.out.print(arr[k][l] + " ");
				}
				System.out.println("");
			}
			
		}
	}
}
