// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PyTLqAf4DFAUq&categoryId=AV5PyTLqAf4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1

package swea.d2;

import java.util.Scanner;

public class Main7 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			
			char[] arr = str.toCharArray();
			char[] rArr = new char[arr.length];
			for(int i = 0; i < arr.length; i++) {
				rArr[i] = arr[arr.length-1-i];
			}
			
			String rStr = new String(rArr);
			
			if(str.equals(rStr)) {
				System.out.println("#" + tc + " " + 1);
			}else {
				System.out.println("#" + tc + " " + 0);
			}
		}
	}
}
