-- https://school.programmers.co.kr/learn/courses/30/lessons/131529

SELECT LEFT(PRODUCT_CODE, 2) AS CATEGORY, COUNT(PRODUCT_ID) AS PRODUCTS
FROM PRODUCT
GROUP BY CATEGORY
ORDER BY CATEGORY