// https://school.programmers.co.kr/learn/courses/30/lessons/120807
// 2023 04 03 화 자바인 줄 알고 C언어로 잘못 풂

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int num1, int num2) {
    int answer = 0;
    
    if(num1 == num2) {
        answer = 1;
    }else {
        answer = -1;
    }
    
    return answer;
}