-- https://school.programmers.co.kr/learn/courses/30/lessons/59412

SELECT DATE_FORMAT(DATETIME, '%H') AS HOUR, COUNT(SEX_UPON_OUTCOME)
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR >= 9 AND HOUR < 20
ORDER BY HOUR