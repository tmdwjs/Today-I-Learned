// ListIterator 사용
package baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class 에디터_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine(); // 문자
        int n = Integer.parseInt(br.readLine()); // 커맨드 개수

        // 문자를 linkedList에 담기
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        // ListIterator 사용
        // ListIterator는 양방향 탐색이 가능하다.
        // list -> iter
        ListIterator<Character> iter = list.listIterator();

        // 커서
        // 처음 시작 시 커서는 맨 뒤에서 시작해야 함(abe|)
        while(iter.hasNext()) {
            iter.next(); // 맨 뒤로 보내는 과정
        }

        // n만큼 돌며 커맨드를 한 줄씩 받음
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                case 'L':
                    // 이전으로(왼쪽으로) 보낼 수 있으면
                    if (iter.hasPrevious()) {
                        iter.previous(); // previous 실행
                    }

                    break;

                case 'D':
                    if (iter.hasNext()) {
                        iter.next(); // previous 실행
                    }

                    break;

                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();;
                    }

                    break;

                default:
                    char s = command.charAt(2);
                    iter.add(s);

                    break;
            }
        }

        for (char el: list) {
            bw.write(el);
        }

        bw.flush();
        bw.close();
    }
}

// LinkedList 사용
// 시간 초과
// package baekjoon.silver;

// import java.io.*;
// import java.util.LinkedList;
// import java.util.StringTokenizer;

// public class 에디터_1406 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//         String str = br.readLine(); // 문자
//         int n = Integer.parseInt(br.readLine()); // 커맨드 개수

//         // 문자를 linkedList에 담기
//         LinkedList<Character> list = new LinkedList<>();

//         for (int i = 0; i < str.length(); i++) {
//             list.add(str.charAt(i));
//         }

//         // 커서
//         // 처음 시작 시 커서는 맨 뒤에서 시작해야 함(abe|)
//         int cursor = list.size();

//         // n만큼 돌며 커맨드를 한 줄씩 받음
//         for (int i = 0; i < n; i++) {
//             String command = br.readLine();
//             char c = command.charAt(0);

//             switch (c) {
//                 case 'L':
//                     if (cursor != 0) {
//                         cursor -= 1;
//                     }
//                     break;

//                 case 'D':
//                     if (cursor != list.size()) {
//                         cursor += 1;
//                     }

//                     break;

//                 case 'B':
//                     if (cursor != 0) {
//                         list.remove(cursor - 1);
//                         cursor--;
//                     }

//                     break;
                    
//                 default:
//                     char s = command.charAt(2);
//                     list.add(cursor, s);
//                     cursor++;

//                     break;
//             }
//         }

//         for (char el: list) {
//             bw.write(el);
//         }

//         bw.flush();
//         bw.close();
//     }
// }