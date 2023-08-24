// https://www.acmicpc.net/problem/2606

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스_2606 {
    // 1. 입력
    private static int node; // 노드 수(컴퓨터 수)
    private static int line; // 라인 수(연결된 컴퓨터 수)
    private static int[][] arr;
    private static int count = 0; // 카운트 후 정답으로 return 될 변수
    private static boolean[] visited; // 방문 시 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 2. 배열 입력
            arr[a][b] = arr[b][a] = 1; // 1, 2번이나 2, 1번이나 같음
        }

        // 3. dfs
        dfs(1); // 1번 컴퓨터가 감염됐을 시에 컴퓨터 개수를 찾는 것이니 1 입력
        // 4. 출력
        System.out.println(count - 1); // 처음 1번 컴퓨터는 제외
    }

    public static void dfs(int start) {
        visited[start] = true; // 컴퓨터 번호 false -> true 체크
        count ++;

        for (int i = 0; i <= node; i++) {
            // 인접한 컴퓨터가 감염됐으면서, && 아직 방문하지 않은 컴퓨터라면
            if (arr[start][i] == 1 && !visited[i]) {
                dfs(i); // dfs 입력
            }
        }
    }
}
