// 1. 반복문을 이용한 풀이(효율성 불합격)

// https://school.programmers.co.kr/learn/courses/30/lessons/42577

// package programmers.level2;

// import java.util.Arrays;

// public class 전화번호_목록 {
//     public static void main(String[] args) {
//         String[] phone_book = {"12","123","1235","567","88"};
//         System.out.println(solution(phone_book));
//     }

//     public static boolean solution(String[] phone_book) {
//         boolean answer = true;

//         Arrays.sort(phone_book);

//         for (int i = 0; i < phone_book.length - 1; i++) {
//             for (int j = i + 1; j < phone_book.length; j++) {
//                 if (phone_book[j].startsWith(phone_book[i])) answer = false;
//             }
//         }

//         return answer;
//     }
// }

// 2. 해시를 이용한 풀이

// https://school.programmers.co.kr/learn/courses/30/lessons/42577

package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 전화번호_목록 {
    public static void main(String[] args) {
        String[] phone_book = {"12","123","1235","567","88"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        // 1. HashMap 선언
        Map<String, Integer> map = new HashMap<>();

        // 2. HashMap에 모든 전화번호 추가
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        // 3. HashMap에 존재하는지 확인
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                }
            }
        }

        return answer;
    }
}

// 해시를 이용해 한 번 더 풂

// https://school.programmers.co.kr/learn/courses/30/lessons/42577

// package programmers.level2;

// import java.util.HashMap;
// import java.util.Map;

// public class 전화번호_목록_2 {
//     public static void main(String[] args) {
//         String[] phone_book = {"119", "97674223", "1195524421"};
//         System.out.println(solution(phone_book));
//     }

//     public static boolean solution(String[] phone_book) {
//         boolean answer = true;
//         Map<String, Integer> map = new HashMap<>();

//         for (int i = 0; i < phone_book.length; i++) {
//             map.put(phone_book[i], i);
//         }

//         for (int i = 0; i < phone_book.length; i++) {
//             for (int j = 0; j < phone_book[i].length(); j++) {
//                 if (map.containsKey(phone_book[i].substring(0, j))) {
//                     answer = false;
//                 }
//             }
//         }

//         return answer;
//     }
// }
