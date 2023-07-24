// https://school.programmers.co.kr/learn/courses/30/lessons/120895

import java.lang.*;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder(my_string);
        
        char temp = sb.charAt(num1); // temp = hello의 e
        
        sb.setCharAt(num1, sb.charAt(num2)); // 1에 charAt(2)를 
        sb.setCharAt(num2, temp); // 2에 charAt(1)을
                                  // 위처럼 안 한 이유는, 한 번 바뀌면 순서가 바뀌니, temp에 원본을 저장해둔 것
        
        return sb.toString();
        
    }
}