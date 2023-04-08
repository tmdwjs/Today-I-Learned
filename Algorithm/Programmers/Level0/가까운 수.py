# https://school.programmers.co.kr/learn/courses/30/lessons/120890

def solution(array, n):
    ans = 0
    tem = float('inf')
    
    for i in array:
        diff = abs(i - n)
        
        if diff < tem:
            ans = i
            tem = diff
        elif diff == tem:
            ans = min(i, ans)
            
    return ans