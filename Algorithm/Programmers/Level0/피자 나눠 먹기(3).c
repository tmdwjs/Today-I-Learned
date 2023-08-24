// https://school.programmers.co.kr/learn/courses/30/lessons/120816
// 2023 04 03 화 자바인 줄 알고 C언어로 잘못 풂

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int slice, int n) {
    int answer = 0;
    
    if(n % slice == 0){
        answer = n / slice;
    }else {
        answer = n / slice + 1;
    }
    
    return answer;
}