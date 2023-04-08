# https://school.programmers.co.kr/learn/courses/30/lessons/120843?language=python3

# 요세푸스 문제
def solution(numbers, k):
    return numbers[2 * (k - 1) % len(numbers)]