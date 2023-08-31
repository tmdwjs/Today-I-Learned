// https://www.acmicpc.net/problem/1541

package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 잃어버린_괄호_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // +와 -만 있기 때문에, 최솟값은 먼저 더하고 빼야 가장 작은 값을 도출할 수 있다.
        StringTokenizer subtract = new StringTokenizer(br.readLine(), "-");
        int ans = Integer.MAX_VALUE; // 답을 0으로 초기화

        // - 반복문
        while (subtract.hasMoreTokens()) {
            int add = 0;

            StringTokenizer addition = new StringTokenizer(subtract.nextToken(), "+");

            // + 반복문
            while (addition.hasMoreTokens()) {
                add += Integer.parseInt(addition.nextToken());
            }

            // 우선적으로 ans에 현재 더한 애들을 할당해 줘야 함
            // 처음에는 무조건 해당 조건문이 실행될 것
            if (ans == Integer.MAX_VALUE) {
                ans = add;

            // 토큰이 다 돌 때까지(앞에 -로 나뉘어진 토큰들) 빼 주기
            } else {
                ans -= add;
            }
        }

        System.out.println(ans);
    }
}
