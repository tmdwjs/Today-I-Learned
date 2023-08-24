# https://school.programmers.co.kr/learn/courses/30/lessons/120853

def solution(s):
    answer = 0
    prev = 0
    
    for i in s.split(' '):
        try:
            answer += int(i)
            prev = int(i)
        except:
            answer -= prev
                
    return answer