// https://school.programmers.co.kr/learn/courses/30/lessons/120830
// 2023 04 03 화 자바인 줄 알고 C언어로 잘못 풂

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n, int k) {
    int answer = 0;
    int drink = 0;
    
    drink += n / 10;
    
    answer = (n * 12000) + (k * 2000) - (drink * 2000);
    
    return answer;
}