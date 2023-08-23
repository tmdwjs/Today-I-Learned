// https://www.acmicpc.net/problem/1021

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는_큐_1021 {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 큐의 크기
        int m = Integer.parseInt(st.nextToken()); // 뽑고자 하는 개수
        LinkedList<Integer> deque = new LinkedList<>();

        // 1부터 주어진 n까지 덱에 담음
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        int[] arr = new int[m]; // 뽑고자 하는 배열
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0; // 카운트 할 변수

        // 2. 로직
        for (int i = 0; i < m; i++) {
            int target_idx = deque.indexOf(arr[i]); // 찾고자 하는 요소의 인덱스 타겟으로 잡음
            int half_idx = deque.size() % 2 == 0 ? deque.size() / 2 - 1 : deque.size() / 2;

            // 타겟 인덱스가 중간보다 왼쪽이면, 왼쪽으로 보내기 = 2번 연산 실행
            if (target_idx <= half_idx) {
                // 타겟 인덱스만큼 연산 실행
                for (int j = 0; j < target_idx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count ++;
                }

            // 타겟 인덱스가 중간보다 오른쪽이면, 오른쪽으로 보내기 = 3번 연산 실행
            } else {
                // 타겟 인덱스만큼 연산 실행
                for (int j = 0; j < deque.size() - target_idx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count ++;
                }
            }

            deque.pollFirst(); // 연산 종료 시 맨 앞 원소 삭제 = 1번 연산 실행

        }

        System.out.println(count);

    }
}
