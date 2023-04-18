// https://www.acmicpc.net/problem/1475

// 풀이 1번
// 이 풀이는 6과 9를 뒤집어 사용 가능한 것이 고려되지 않음
// 즉, 문제의 원초적인 목적은 달성했지만, 6과 9를 뒤집어 사용 가능한 로직 처리는 안 돼 있기 때문에 틀린 코드
// 기록용으로 작성함

// package baekjoon.silver;

// import java.util.Scanner;

// public class 방_번호 {
// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		String str = sc.next();
		
// 		int count = 1;
// 		String check = "";

// 		for (int i = 0; i < str.length(); i++) {
// 			if (check.contains(str.substring(i, i + 1))) 
// 				count ++;

// 			check += str.substring(i, i + 1);
// 		}
		
// 		System.out.println(count);
// 	}
// }

// 풀이 2번
package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 방_번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] arr = new int[10];

		for (int i = 0; i < s.length(); i++) {
			int num = Character.getNumericValue(s.charAt(i));

			if (num == 9)
				arr[6]++;
			else
				arr[num]++;
		}

		arr[6] = (int) Math.ceil((double) arr[6] / 2.0);

		Arrays.sort(arr);

		System.out.println(arr[arr.length - 1]);
	}
}
