# https://school.programmers.co.kr/learn/courses/30/lessons/120864

def solution(my_string):
    ans = 0 # 정답 
    num = ""
    # 1. 34일 경우, 3+4=7이 아닌 34로 봐야 함
    # 즉, 문자열로 먼저 더해줘야 함
    
    for el in my_string:
        if el.isdigit(): # 2. 숫자인지 아닌지 확인
            num += el # 3. 문자열 이어 붙이기
        
        # 4. if에 해당 안 되면(숫자가 아닌 문자라면)
        else:
            # 5. 기존 더했던 숫자들에 대해 
            if num:
                ans += int(num) # 6. 숫자로 형변환 후 더해준 뒤
                num = "" # 7. 초기화
    
    # 8. 마지막이 숫자로 끝나는 경우, 5.의 과정을 못 거치기 때문에 마지막으로 한 번 더 조건문 작성
    if num:
        ans += int(num)
                
    return ans