// https://www.acmicpc.net/problem/1926

package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림_1926 {
        public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로 사이즈
        int m = Integer.parseInt(st.nextToken()); // 가로 사이즈
        int[][] board = new int[n][m]; // 그림
        boolean[][] visited = new boolean[n][m]; // 방문 여부
        Queue<Pair> queue = new LinkedList<>(); // 담을 queue(Pair 타입)

        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 로직
        int cnt, size, max;
        cnt = size = max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 방문 O
                // 0이거나 방문했으면 스킵
                if (board[i][j] == 0 || visited[i][j]) continue;

                // 방문 X
                cnt++; // 위 조건에 해당 안 되니 개수 + 1
                queue.offer(new Pair(i, j)); // 방문했으니 queue에 저장
                visited[i][j] = true; // 방문 처리
                size = 0; // 그림 넓이 구한 뒤 0으로 초기화

                while (!queue.isEmpty()) {
                    // 방문 X 기준으로 사방 살피기
                    Pair pair = queue.poll();
                    size++; // 넓이 + 1

                    for (int k = 0; k < 4; k++) {
                        int nx = pair.getX() + dx[k];
                        int ny = pair.getY() + dy[k];

                        // 그림 벗어나면 스킵
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                        // 그림 내에서,
                        // 붙어있는 그림이면서 && 방문 한 적 없으면
                        if (board[nx][ny] == 1 && !visited[nx][ny]) {
                            queue.offer(new Pair(nx, ny)); // queue에 저장
                            visited[nx][ny] = true; // 방문 표시
                        }
                    }
                }

                max = Math.max(size, max);
            }
        }

        // 3. 출력
        System.out.println(cnt);
        System.out.println(max);
    }
}

// 2. pair 클래스 생성
// pair 클래스는 두 자료형을 묶어 가지고 다닐 수 있게 해 주는 역할을 함
class Pair {
    private int x;
    private int y;

    public Pair () {

    }

    public Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
