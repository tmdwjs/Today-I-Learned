// https://school.programmers.co.kr/learn/courses/30/lessons/160586

package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 대충_만든_자판 {
    public static void main(String[] args) {
        String[] keymap = {"AGZ", "BSSS"};
        String[] targets = {"ASA","BGZ"};
        System.out.println(Arrays.toString(solution(keymap, targets)));
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for (String key: keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);

                if (!map.containsKey(c) || i < map.get(c)) {
                    map.put(c, i + 1);
                }
            }
        }

//        A: 1
//        B: 1
//        C: 2
//        D: 5
//        E: 3
//        F: 4

        for (int i = 0; i < targets.length; i++) {
            int count = 0;

            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);

                if (!map.containsKey(c)) {
                    count = 0;
                    break;
                } else {
                    count += map.get(c);
                }
            }

            answer[i] = count == 0 ? -1 : count;
        }

        return answer;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/160586

// package programmers.level1;

// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.Map;

// public class 대충_만든_자판_2 {
//     public static void main(String[] args) {
//         String[] keymap = {"ABACD", "BCEFD"};
//         String[] targets = {"ABCD","AABB"};
//         System.out.println(Arrays.toString(solution(keymap, targets)));
//     }

//     public static int[] solution(String[] keymap, String[] targets) {
//         int[] answer = new int[targets.length];

//         // A, B, C, ...에 대해, 가장 앞에 나오는 인덱스만 가지고 있으면 됨
//         // 즉, key: value가 알파벳: 가장 빠른 인덱스 형태의 map을 만들고,
//         // targets 배열을 반복문 돌며, 인덱스를 누적하여 더해주면 끝

//         Map<Character, Integer> map = new HashMap<>();

//         for (String key: keymap) {
//             for (int i = 0; i < key.length(); i++) {
//                 char c = key.charAt(i);

//                 if (!map.containsKey(c) || i < map.get(c)) {
//                     map.put(c, i + 1);
//                 }
//             }
//         }

//         for (int i = 0; i < targets.length; i++) {
//             int count = 0;

//             for (int j = 0; j < targets[i].length(); j++) {
//                 char c = targets[i].charAt(j);

//                 if (!map.containsKey(c)) {
//                     count = 0;
//                     break;
//                 } else {
//                     count += map.get(c);
//                 }
//             }

//             answer[i] = count == 0 ? -1 : count;
//         }

//         return answer;
//     }
// }
