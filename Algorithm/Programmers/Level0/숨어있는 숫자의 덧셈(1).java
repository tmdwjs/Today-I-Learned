// https://school.programmers.co.kr/learn/courses/30/lessons/120851

import java.lang.*;

class Solution {
    public int solution(String my_string) {
        int sum = 0;
        
        for(int i = 0; i < my_string.length(); i++){
            if(Character.isDigit(my_string.charAt(i))){
                sum += my_string.charAt(i) - '0';
            }
        }
        
        return sum;
    }
}