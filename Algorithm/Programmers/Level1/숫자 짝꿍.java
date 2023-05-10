// https://school.programmers.co.kr/learn/courses/30/lessons/131128

import java.lang.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        
        for (String el: X.split("")) arrX[Integer.parseInt(el)]++;
        for (String el: Y.split("")) arrY[Integer.parseInt(el)]++;
        
        for (int i = 9; i >= 0; i--) {
            while (arrX[i] > 0 && arrY[i] > 0) {
                sb.append(i);
                arrX[i] --;
                arrY[i] --;
            }
        }
        
        if (sb.toString().isEmpty()) return "-1";
        else if (sb.toString().substring(0, 1).equals("0")) return "0";
        else return sb.toString();
    }
}