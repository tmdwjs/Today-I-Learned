// https://school.programmers.co.kr/learn/courses/30/lessons/120911

import java.util.*;

class Solution {
    public String solution(String my_string) {
        String[] arr = new String[my_string.length()];
        String ans = "";
        
        // [1] 소문자로 변경
        for(int i = 0; i < my_string.length(); i++){
            arr[i] = String.valueOf(my_string.charAt(i)).toLowerCase();
        }
        
        // [2] 정렬
        Arrays.sort(arr);
        
        // [3] 출력
        for(String el: arr){
            ans += el;
        }
        
        return ans;
    }
}