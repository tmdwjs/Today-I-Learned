// https://school.programmers.co.kr/learn/courses/30/lessons/161989

package programmers.level1;

public class 덧칠하기 {
    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6};

        System.out.println(solution(n, m, section));
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        int cur = 0;

        for (int i = 0; i < section.length; i++) {
            if (section[i] < cur) {
                continue;
            }

            cur = section[i] + m;
            answer ++;
        }

        return answer;
    }

}
