// https://school.programmers.co.kr/learn/courses/30/lessons/49993

package programmers.level2;

public class 스킬트리 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree: skill_trees) {
            String reStr = skill_tree;

            for (int i = 0; i < skill_tree.length(); i++) {
                String s = String.valueOf(skill_tree.charAt(i));

                if (!skill.contains(s))
                    reStr = reStr.replace(s, "");
            }

            if (skill.indexOf(reStr) == 0)
                answer ++;
        }

        return answer;
    }
}
