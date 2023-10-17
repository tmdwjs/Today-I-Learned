-- https://school.programmers.co.kr/learn/courses/30/lessons/157342

SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1), 1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC

-- 3번 라인 DATEDIFF() 함수에서 +1을 해 준 이유는,
-- 예를 들어 1월 1일에 빌리고 1월 1일에 반납한 경우,
-- 1일이 아닌 0일을 리턴하기 때문에,
-- DATEDIFF() 함수에 1을 더해주는 것이다.