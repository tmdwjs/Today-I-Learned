1. dvd 렌탈 업체의 dvd 대여가 있었던 날짜를 확인하세요.
```sql
select distinct date(r.rental_date)
  from rental
```

3. 직원의 id가 2번인 직원의 id, 이름, 성을 확인하세요.
(단, '이름, 성'의 양식으로 name이란 컬럼명 사용합니다.)
```sql
select customer_id
     , first_name || ', ' || last_name as "name"
  from customer
 where customer_id = 2
```

<code>||</code>는 <code>concat</code> 함수와 같은 문자를 이어주는 역할을 합니다.

7. 대여 기간이 10일 이상이었던 rental 테이블에 대해 모든 정보를 확인하세요.
(단, 대여 기간은 대여일자로부터 대여기간으로 포함합니다.)
```sql
select *
  from rental
  where date(return_date) - date(rental_date) + 1 >= 10
```

만약 1일에 대여하고 1일에 반납하게 돼도 1일 대여한 것이기 때문에, + 1을 해 줍니다.

15.  film 테이블을 활용해, 2006년에 출시가 되고 rating이 'G' 등급에 해당하며, 대여기간이 3일에 해당하는 것에 대한 film 테이블의 모든 컬럼을 확인하세요.
```sql
select *
  from film
 where release_year 2006
   and rating = 'G'
   and retal_duration = 3
```

18. film 테이블을 활용해, rental_duration 대여가 가능한 일자가 3일 또는 5일에 해당하는 film_id, title, description 컬럼을 확인하세요.
```sql
select film_id
     , title
     , description
     , rental_duration  
  from film
 where rental_duration in (3, 5)
```
