> JOIN에 대해 학습합니다.

JOIN 이전에 FROM과 WHERE 절에서 테이블을 합치는 것부터 보겠습니다.

```sql
select count(*) -- 599
  from customer c 
  
select count(*) -- 16,044
  from rental r
  
-- 테이블을 두 개 가져오면 cross join을 함

select count(*) -- 9,610,356 (599 * 16044)
  from customer c , rental r
  
select count(*) -- 1,604,400 (100 * 16044)
  from customer c , rental r 
 where c.customer_id <= 100
 
-- 그래서 둘의 관계를 맺어주기 위해 조건을 걸어주며,
-- ansi sql 표준이 join을 통해 관계를 맺어주는 것

select count(*) -- 16,044
  from customer c , rental r 
 where c.customer_id = r.customer_id 
 
select count(distinct c.customer_id) -- 16044
  from customer c 
  	   join rental r on c.customer_id = r.customer_id 

-- rental 테이블에 customer id를 참조하고 있어,
-- id가 중복돼 있기 때문에 rental 개수만큼 출력이 되는 것
-- distinct를 통해 중복을 제거하면 customer 개수만큼 데이터가 출력됨

select count(distinct c.customer_id) -- 599
  from customer c , rental r 
 where c.customer_id = r.customer_id
```

...

10. country가 chin 가 아닌 지역에 사는, 고객의 이름(first_name, last_name)과, email, phone number, country, city를 알려주세요.

```sql
select c.first_name 
	 , c.last_name 
	 , c.email 
	 , a.phone as phonenumber
	 , c3.country 
	 , c2.city 
  from customer c 
       join address a  on c.address_id  = a.address_id 
       join city c2    on a.city_id     = c2.city_id 
       join country c3 on c2.country_id = c3.country_id 
 where c3.country != 'China'
```