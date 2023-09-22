-- https://school.programmers.co.kr/learn/courses/30/lessons/132202

-- 1
SELECT MCDP_CD AS 진료과코드, COUNT(APNT_NO) AS 5월예약건수
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, '%Y-%m-%d') BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY MCDP_CD
ORDER BY 5월예약건수, MCDP_CD

--2
SELECT MCDP_CD AS '진료과코드', COUNT(APNT_NO) AS `5월예약건수`
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, '%Y-%m-%d') BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY MCDP_CD
ORDER BY `5월예약건수`, MCDP_CD

-- 2
SELECT MCDP_CD AS '진료과코드', COUNT(APNT_NO) AS '5월예약건수'
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, '%Y-%m-%d') BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY MCDP_CD
ORDER BY COUNT(APNT_NO), MCDP_CD

-- 앨리어싱 시, 앨리어싱 명칭으로 정렬이 가능합니다.
-- 단, 따옴표를 사용한 경우, 문자열 그대로로 해석하기 때문에,
-- 앨리어싱으로 정렬이 불가능합니다.

-- 즉, 1번처럼 따옴표를 사용하지 않거나
-- 2번처럼 백틱(``)을 사용거나
-- 3번처럼 집계 함수를 한 번 더 사용해주면 됩니다.