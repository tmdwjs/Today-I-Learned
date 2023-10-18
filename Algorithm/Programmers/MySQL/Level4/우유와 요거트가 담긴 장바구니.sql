-- https://school.programmers.co.kr/learn/courses/30/lessons/62284

SELECT DISTINCT A.CART_ID
FROM CART_PRODUCTS A
INNER JOIN CART_PRODUCTS B
ON A.CART_ID = B.CART_ID
WHERE A.NAME = 'Milk' AND B.NAME = 'Yogurt'
ORDER BY CART_ID

-- 조인 후 조건절에서 출력