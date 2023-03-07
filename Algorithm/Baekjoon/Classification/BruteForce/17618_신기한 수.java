// https://www.acmicpc.net/problem/17618
// 17618 신기한 수

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()); // 입력 받은 정수
			int cnt = 0; // 카운트 할 변수

			// 1보다 크고 입력 받은 정수 이하인 애들을 하나씩 체크할 것
			for(int i = 1; i <= n; i++) {
				int j = i;
				int sum = 0;
				
				// 기존엔 10으로 나눈 값이 0보다 크면 10으로 나눈 수를 재할당 해 주고,
				// 그 외엔 아래에서 조건문을 한 번 더 추가해 줬는데,
				// 처음부터 바로 반복문을 돌리게 되면,
				// 불필요한 조건문을 삭제함으로써 시간을 단축시킬 수 있다
				// 반복문 조건이 j가 0보다 클 때만 실행되기 때문에 
				// j가 10 이하로 떨어지게 되면, 자동적으로 반복문은 종료된다.
				while(j > 0) {
					sum += j % 10;
					j /= 10;
				}
				
				if(i % sum == 0) {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
