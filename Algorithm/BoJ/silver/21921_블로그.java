// https://www.acmicpc.net/problem/21921

// 시도 2. 통과
package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int count = 0;

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
            count = 1;

            for (int i = x; i < n; i++) {
                sum = sum - today[i - x] + today[i];
                if (sum > max) {
                    max = sum;
                    count = 1;
                } else if (sum == max) {
                    count++;
                }
            }

            System.out.println(max);
            System.out.println(count);
        }
    }
}


// 시도 1. 시간 초과
// package silver;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// public class 블로그_21921 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int n = Integer.parseInt(st.nextToken());
//         int x = Integer.parseInt(st.nextToken());
//         int[] today = new int[n];
//         int check = 0;
//         int max = 0;
//         int count = 0;

//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < n; i++) {
//             int el = Integer.parseInt(st.nextToken());
//             today[i] = el;
//             check += el;
//         }

//         if (check == 0) {
//             System.out.println("SAD");
//         } else {
//             int sum = 0;
//             for (int i = 0; i < x; i++) {
//                 sum += today[i];
//             }
//             max = sum;
//             count = 1;

//             for (int i = x; i < n; i++) {
//                 sum = sum - today[i - x] + today[i];
//                 if (sum > max) {
//                     max = sum;
//                     count = 1;
//                 } else if (sum == max) {
//                     count++;
//                 }
//             }

//             System.out.println(max);
//             System.out.println(count);
//         }
//     }
// }
