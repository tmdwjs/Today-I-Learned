// https://www.acmicpc.net/submit/11723

// [시도 2] 비트마스크
package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 집합_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int bit = 0;
        int cur_n;

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            String[] actions = command.split(" ");

            switch (actions[0]) {
                case "add":
                    cur_n = Integer.parseInt(actions[1]);
                    bit |= (1 << (cur_n - 1));
                    break;
                case "remove":
                    cur_n = Integer.parseInt(actions[1]);
                    bit = bit & ~(1 << (cur_n - 1));
                    break;
                case "toggle":
                    cur_n = Integer.parseInt(actions[1]);
                    bit ^= (1 << (cur_n - 1));
                    break;
                case "check":
                    cur_n = Integer.parseInt(actions[1]);
                    sb.append((bit & (1 << cur_n - 1)) != 0 ? "1\n" : "0\n");
                    break;
                case "all":
                    bit |= (~0);
                    break;
                case "empty":
                    bit &= 0;
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}



// [시도 1] 시간초과
// package baekjoon.silver;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.Set;
// import java.util.StringTokenizer;

// public class 집합_11723 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         Set<Integer> set = new HashSet<>();
//         ArrayList<Integer> ans = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             String command = br.readLine();
//             String[] actions = command.split(" ");

//             switch (actions[0]) {
//                 case "add":
//                     set.add(Integer.parseInt(actions[1]));
//                     break;

//                 case "check":
//                     if (set.contains(Integer.parseInt(actions[1]))) ans.add(1);
//                     else ans.add(0);
//                     break;

//                 case "remove":
//                     set.remove(Integer.parseInt(actions[1]));
//                     break;

//                 case "toggle":
//                     if (set.contains(Integer.parseInt(actions[1]))) set.remove(Integer.parseInt(actions[1]));
//                     else set.add(Integer.valueOf(actions[1]));
//                     break;

//                 case "all":
//                     for (int j = 1; j <= 20; j++) set.add(j);
//                     break;

//                 case "empty":
//                     set.clear();
//                     break;
//             }
//         }

//         for (int el: ans) System.out.println(el);
//     }
// }
