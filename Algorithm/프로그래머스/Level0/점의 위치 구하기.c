// https://school.programmers.co.kr/learn/courses/30/lessons/120841
// 2023 04 03 화 자바인 줄 알고 C언어로 잘못 풂

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// dot_len은 배열 dot의 길이입니다.
int solution(int dot[], size_t dot_len) {
    int ans = 0;
    
    if(dot[0] > 0 && dot[1] > 0) ans = 1;
    if(dot[0] > 0 && dot[1] < 0) ans = 4;
    if(dot[0] < 0 && dot[1] > 0) ans = 2;
    if(dot[0] < 0 && dot[1] < 0) ans = 3;
    
    return ans;
}