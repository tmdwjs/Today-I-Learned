// https://school.programmers.co.kr/learn/courses/30/lessons/178871

package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 달리기_경주 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        System.out.println(Arrays.toString(solution(players, callings)));
    }

    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        String[] answer = new String[players.length];

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String player: callings) {
            int curRank = map.get(player); // 현재 불린 선수의 순위
            String frontPlayer = players[curRank - 1]; // 현재 불린 선수의 앞 선수

            // map 갱신
            map.put(player, curRank - 1); // 앞 순위로, 현재 선수 배치
            map.put(frontPlayer, curRank); // 현재 순위로, 앞 선수 배치

            // players 배열 갱신
            players[curRank - 1] = player; // 앞 순위로, 현재 선수 배치
            players[curRank] = frontPlayer; // 현재 순위로, 앞 선수 배치
        }

        return players;
    }
}

// 한 번 더 풀어 본 코드

// package programmers.level1;

// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.Map;

// public class 달리기_경주_2 {
//     public static void main(String[] args) {
//         String[] players = {"mumu", "soe", "poe", "kai", "mine"};
//         String[] callings = {"kai", "kai", "mine", "mine"};
//         System.out.println(Arrays.toString(solution(players, callings)));
//     }

//     public static String[] solution(String[] players, String[] callings) {
//         Map<String, Integer> map = new HashMap<>();

//         for (int i = 0; i < players.length; i++) {
//             map.put(players[i], i);
//         }

//         for (int i = 0; i < callings.length; i++) {
//             int curRank = map.get(callings[i]); // 현재 불린 사람의 순위
//             String frontPlayer = players[curRank - 1]; // 그리고 그 순위의 앞 선수

//             map.put(callings[i], curRank - 1);
//             map.put(frontPlayer, curRank);

//             players[curRank - 1] = callings[i];
//             players[curRank] = frontPlayer;
//         }

//         return players;
//     }
// }
