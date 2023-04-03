// https://school.programmers.co.kr/learn/courses/30/lessons/120829
// 2023 04 03 화 자바인 줄 알고 C언어로 잘못 풂

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int angle) {
    int answer = 0;
    
    if(angle > 0 && angle < 90){
        answer = 1;
    }else if(angle == 90){
        answer = 2;
    }else if(angle > 90 && angle < 180){
        answer = 3;
    }else {
        answer = 4;
    }
    
    return answer;
}