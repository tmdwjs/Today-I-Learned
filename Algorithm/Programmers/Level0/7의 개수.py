# https://school.programmers.co.kr/learn/courses/30/lessons/120912

def solution(array):
    cnt = 0
    for num in array:
        for el in str(num):
            if el == '7':
                cnt += 1
    return cnt