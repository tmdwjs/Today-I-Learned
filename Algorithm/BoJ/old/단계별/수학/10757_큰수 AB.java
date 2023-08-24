// https://www.acmicpc.net/problem/10757
// 10757 큰 수 A + B

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main1 {
	public static void main(String[] args) {
		
		
		// BufferedReader로 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 공백을 기준으로 숫자가 들어오기 때문에,
		// split or StringTokenizer로 숫자 두 개로 나눌 것
		// 기능 측면에서 StringTokenizer이 더 좋다고 해서 해당 클래스 사용
		
		// 공백을 기준으로 split
		try {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 예제에서 long 범위를 벗어나는 숫자가 입력될 수 있어서
			// BigInteger 사용
			BigInteger num1 = new BigInteger(st.nextToken());
			BigInteger num2 = new BigInteger(st.nextToken());
			
			System.out.println(num1.add(num2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}