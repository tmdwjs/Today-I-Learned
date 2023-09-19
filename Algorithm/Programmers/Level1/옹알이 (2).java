// https://school.programmers.co.kr/learn/courses/30/lessons/133499

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String el: babbling) {
            el = el.replaceAll("ayaaya|yeye|woowoo|mama", " ");
            el = el.replaceAll("aya|ye|woo|ma", "");
            
            if (el.equals("")) answer++;
        }
        
        return answer;
    }
}