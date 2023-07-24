# 백준
## 문제
https://www.acmicpc.net/problem/1010

## 코드
``` java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main13 {
	static int[][] arr = new int[30][30]; // 최대 입력 29
	// bridges method 내에서 배열 선언 시 시간 초과
	// 전역 static으로 잡아줘야 함

	public static void main(String[] args) throws IOException {
		//  Scanner로 입력을 받을 시 시간 초과
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 반복 횟수

		StringTokenizer st;	// StringTokenizer를 사용해 공백 기준 문자열 split
		StringBuilder sb = new StringBuilder();	// 반복문을 돌 때마다 출력 시, 시간 초과 발생
		// StringBuilder를 사용해 출력할 답을 더해 최종적으로 한 번에 return 할 것
		// 더할 땐 append() method를 사용해 합치면 됨

		// 반복 횟수만큼 반복문 실행
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(bridges(M, N)).append("\n");
		}

		System.out.println(sb);
	}

	// 조합 공식
	static int bridges(int n, int r) {

		// 이미 풀린 경우 바로 return 
		if (arr[n][r] > 0) {
			return arr[n][r];
		}

		// 2번 성질
		// nCn = nC0 = 1
		if (n == r || r == 0) {
			return arr[n][r] = 1;
		}

		// 1번 성질
		// 점화식
		// n+1Cr+1 = nCr + nCr+1
		return arr[n][r] = bridges(n - 1, r - 1) + bridges(n - 1, r);
	}
}
```

## 풀이

해당 문제는 한 사이트에 한 개의 다리만 놓을 수 있고, 다리끼리 겹치면 안 됩니다. 서쪽의 사이트 N 개, 동쪽의 사이트 M 개가 있습니다(N <= M). 즉 최대한 많은 다리를 놓으려면, M개의 사이트 중, N 개를 선택해야 하고, 서로 중복되면 안 됩니다. 여기서 '조합 공식'이 사용됩니다.

조합 공식은 서로 다른 n 개에서 r 개를 뽑는 것으로 <code>nCr</code> 공식이라고 합니다. 해당 문제에서는 M개 중 N개를 뽑는 것이기에 <code>MCN</code>이 됩니다.

문제 풀이에 앞서, '중복 없이 뽑는 것과 별개로 교차 하는 것을 어떻게 피할 수 있을까'가 관건인데, 결론부터 말하면 상관이 없다고 합니다. 예를 들어 [1, 2, 3, 4, 5] 중, [1, 3, 4]를 뽑았다고 가정 시, [1, 3, 4]나 [3, 4, 1]을 1개의 경우로 봅니다.

즉 [3, 1, 4]라면, 서쪽 사이트 [1, 2, 3]이 동쪽 사이트와 교차가 발생했다 볼 수 있지만, [1, 2, 3]이 뽑혔다면 올바르게 연결된 모양일 것입니다. 하지만 앞서 말한 것처럼 조합은 뽑는 순서를 고려하지 않아 [3, 1, 4]나 [1, 2, 3]을 1개의 경우로 보기 때문에, 이미 중복 없이 M 개 중 N 개를 뽑는 것에서 다리가 교차가 것은 배제된 상태인 것입니다.

해당 문제는 조합 공식의 성질을 이용하여 풀었으며 다음 식을 활용하여 풀이했습니다. 성질에 대한 자세한 설명은 하단에 참조한 블로그의 링크를 첨부해 놨습니다.

식 1 점화식:  <code>n+1Cr+1 = nCr + nCr+1</code><br>
식 2: <code>nC0 = nCn = 1</code>

# 노트

해당 문제에서 시간 초과를 벗어나기 위해 두 가지를 했습니다. 하나는 <code>Scanner</code>에서 <code>BufferedReader</code>로 입력을 받은 것이고, 나머지 하나는 반복문이 돌 때마다 출력하는 것이 아닌, <code>StringBuilder</code>을 출력을 한 번에 더해 출력한 것입니다. <code>StringBuilder</code>에 대해선 [다음]()에 작성했습니다.