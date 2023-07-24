-- https://school.programmers.co.kr/learn/courses/30/lessons/131115

-- 내림차순, LIMIT 사용
SELECT *
FROM FOOD_PRODUCT
ORDER BY PRICE DESC
LIMIT 1;

-- MAX(), Sub Query 사용
SELECT *
FROM FOOD_PRODUCT
WHERE PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT)

-- 아래 쿼리문은 오답으로 간주됨
-- 위 쿼리문과 가격은 19000원으로 일치하지만 위는 김치, 아래는 면이 출력됨.
-- 즉, 가격이 같을 때 상품명으로 오름차순을 해야 하는 것 같다.
-- MAX() 사용하고 싶으면, 두 번째 쿼리문처럼 작성하면 될 것 같다.

-- SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, MAX(PRICE) AS PRICE
-- FROM FOOD_PRODUCT