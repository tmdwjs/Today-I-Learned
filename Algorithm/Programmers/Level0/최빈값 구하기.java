// https://school.programmers.co.kr/learn/courses/30/lessons/120812

import java.util.*;

class Solution {
    public int solution(int[] arr) {
        // 1. 정렬
        Arrays.sort(arr);
        
        // 2. 배열 생성
        int[] newArr = new int[1000];
        Arrays.fill(newArr, 0); // {0, 0, 0, ..., 0, 0}
        
        // 3. 반복문 돌며 개수 체크
        for(int i = 0; i < arr.length; i++){
            newArr[arr[i]]++;
        }
        
        // 4. 최빈값 구하기
        int maxCnt = 0;
        int maxNum = 0;
        
        for(int i = 0; i < newArr.length; i++){
            if (newArr[i] > maxCnt){
                maxCnt = newArr[i];
                maxNum = i;
            }
        }
        
        // 5. 최빈값 2개인지 체크
        int cnt = 0;
        
        for(int i = 0; i < newArr.length; i++){
            if(maxCnt == newArr[i]){
                cnt++;
            }
        }
        
        // 6. 최빈값에 따른 조건문
        if(cnt > 1){
            return -1;
        }else {
            return maxNum;
        }
    }
}