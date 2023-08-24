// https://school.programmers.co.kr/learn/courses/30/lessons/120831
// 2023 04 03 화 자바인 줄 알고 C언어로 잘못 풂

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    
    for(int i = 1; i <= n; i++){
        if(i % 2 == 0){
             answer += i;
        }
       
    }
    return answer;
}