// 시도 2. 통과
// https://www.acmicpc.net/problem/21921

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 블로그_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] today = new int[n];
        int check = 0;
        int max = 0;
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int el = Integer.parseInt(st.nextToken());
            today[i] = el;
            check += el;
        }

        if (check == 0) {
            System.out.println("SAD");
        } else {
            int sum = 0;

            for (int i = 0; i < x; i++) {
                sum += today[i];
            }

            max = sum;
            cnt = 1;

            for (int i = x; i < n; i++) {
                sum += today[i] - today[i - x];

                if (sum > max) {
                    max = sum;
                    cnt = 1;
                } else if (sum == max){
                    cnt ++;
                }
            }

            System.out.println(max);
            System.out.println(cnt);
        }
    }
}


// 시도 1. 시간 초과
// https://www.acmicpc.net/problem/21921

/* package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 블로그_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] today = new int[n];
        int check = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int el = Integer.parseInt(st.nextToken());
            today[i] = el;
            check += el;
        }

        if (check == 0) {
            System.out.println("SAD");
        } else {
            for (int i = 0; i < n - x + 1; i++) {
                int sum = 0;

                for (int j = i; j < i + x; j++) {
                    sum += today[j];
                }

                if (sum >= max) {
                    max = sum;
                    map.put(max, map.getOrDefault(max, 0) + 1);
                }
            }

            System.out.println(max);
            System.out.println(map.get(max));
        }
    }
} */