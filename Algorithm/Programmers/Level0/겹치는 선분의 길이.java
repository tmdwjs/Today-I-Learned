// https://school.programmers.co.kr/learn/courses/30/lessons/120876

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        // 범위가 -100 ~ 100이기 때문에, 길이 200의 배열 생성
        int[] check = new int[200];
        
        // 선분을 받고
        for (int[] line: lines) {
            // -100 ~ 100이기 때문에, 100을 더해줘야 0, 0에서 시작하는 것
            int start = line[0] + 100;
            int end = line[1] + 100;
            
            // start부터 end까지 1을 더해주게 되면
            // 겹치는 부분은 2 이상이 될 것임
            // 1보다 큰 수를 카운트 해 주면 정답
            for (int i = start; i < end; i++) {
                check[i] +=1 ;
            }
        }
        
        for (int i: check) {
            if (i > 1) answer ++;
        }
        
        return answer;
    }
}