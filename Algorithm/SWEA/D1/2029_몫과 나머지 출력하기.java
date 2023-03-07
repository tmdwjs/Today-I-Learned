// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QGNvKAtEDFAUq&categoryId=AV5QGNvKAtEDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=1&pageSize=10&pageIndex=2
// 제출 시 아래 코드는 런타임 에러가 발생함
// 따라서 SWEA에 기본 세팅 돼 있는 Scanner로 입력을 받아 제출함
// 답은 일치

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 3
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println("#"+i + " " + (a / b) + " " + (a % b));
		}
	}
}