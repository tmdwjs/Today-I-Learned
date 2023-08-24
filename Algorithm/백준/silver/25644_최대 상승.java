// https://www.acmicpc.net/problem/25644

package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_상승_25644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int answer = 0;
        int min = Integer.MAX_VALUE; // 초기화

        while (n-- > 0) {
            int cur = Integer.parseInt(st.nextToken());
            answer = Math.max(answer, cur - min);
            min = Math.min(min, cur);

//            System.out.println("cur : " + cur);
//            System.out.println("answer : " + answer);
//            System.out.println("min : " + min);
        }

        System.out.println(answer);
    }
}


// 시간 초과

// https://www.acmicpc.net/problem/25644

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());

//         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//         int[] arr = new int[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = Integer.parseInt(st.nextToken());
//         }

//         int max = 0;

//         for (int i = 0; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (arr[i] < arr[j]) {
//                     max = Math.max(max, (arr[j] - arr[i]));
//                 }
//             }
//         }

//         System.out.println(max);
//     }
// }