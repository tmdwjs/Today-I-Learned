// https://school.programmers.co.kr/learn/courses/30/lessons/159994

package programmers.level1;

public class 카드뭉치 {
    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(solution(cards1, cards2, goal));
    }
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int cards1Idx = 0;
        int cards2Idx = 0;

        for (int i = 0; i < goal.length; i++) {
            String curStr = goal[i];

            if (cards1Idx < cards1.length && cards1[cards1Idx].equals(curStr)) {
                cards1Idx++;
            } else if (cards2Idx < cards2.length && cards2[cards2Idx].equals(curStr)){
                cards2Idx++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
