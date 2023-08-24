# https://school.programmers.co.kr/learn/courses/30/lessons/120896

def solution(s):
    ans = ''
    
    for el in s:
        if s.count(el) == 1:
            ans += el
    
    ans = ''.join(sorted(ans))
    
    return ans