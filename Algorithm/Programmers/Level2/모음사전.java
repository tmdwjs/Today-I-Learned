package Algorithm.Programmers.Level2;

public class 모음사전 {
    public static void main(String[] args) {
        String word = "EIO";
        System.out.println(solution(word));
    }

    public static int solution(String word) {
        int answer = 0;
        int[] arr = {781, 156, 31, 6, 1};
        String str = "AEIOU";
        int idx = 0;

        for (int i = 0; i < word.length(); i++) {
            idx = str.indexOf(word.charAt(i));
            answer += (arr[i] * idx) + 1;
        }

        return answer;
    }
}
