> 인라인 뷰와 스칼라 서브쿼리, 그리고 IN, ANY 연산자 등 서브쿼리에 대해 학습합니다.

스칼라 서브쿼리의 사용법에 대해 알아보겠습니다. 아래 한 개의 쿼리가 있습니다.

```sql
select c.customer_id 
     , c.first_name 
     , c.last_name 
     , a.address 
     , a.district 
     , a.postal_code 
     , a.phone 
     , ct.city 
  from customer c 
  join address a on c.address_id = a.address_id 
  join city   ct on a.city_id    = ct.city_id
```

고객의 아이디와 이름, 주소, 도시명을 가져오는 쿼리인데요. 주소와 도시에 대한 정보를 가져오기 위해 고객 정보 기준으로 조인을 시켜주고 있습니다.
조인 없이 해당 쿼리처럼 다른 테이블의 컬럼을 가져오기 위해선 다음과 같이 할 수 있습니다.

```sql
select c.customer_id
     , c.first_name 
     , c.last_name
     , ( select a.address
           from address a 
          where a.address_id = c.address_id 
       )
     , ( select a.district
           from address a 
          where a.address_id = c.address_id 
       )
     , ( select a.postal_code 
          from address a 
         where a.address_id = c.address_id 
     )
     , ( select a.phone 
           from address a 
         where a.address_id = c.address_id 
     )
     , ( select c2.city
          from city c2 
         where c2.city_id in ( select a2.city_id 
                                 from address a2 
                                where a2.address_id = c.address_id
                          )
       )
   from customer c 
```

이처럼 스칼라 서브쿼리는 하나의 컬럼을 반환합니다. 스칼라 서브쿼리는 다음과 같은 상황에서 사용이 가능합니다.

데이터의 증감이 거의 없을 거라 생각되는 테이블에 한해 사용할 수 있습니다.
데이터 말고 코드명을 수십 개 보여주는 경우(상태 반품 코드, 연간 코드 등), 조인을 수십 번 걸 수가 없는 노릇입니다.
따라서 이처럼 데이터 증감이 거의 없는 경우 사용할 수 있습니다.

1. 매출을 가장 많이 올린 dvd 고객 이름은 무엇인가요?

```sql
select customer_id , first_name , last_name 
  from customer c 
 where customer_id in ( select customer_id -- sum(amount): 211.55
                          from payment p 
                         group by customer_id
                         order by sum(amount) desc 
                         limit 1 
                      )
```

2. 대여가 한번도이라도 된 영화 카테 고리 이름을 알려주세요.

<code>exist</code> 사용

```sql
select c.name
  from category c  
 where exists ( select fc.category_id 
                 from rental r 
                 join inventory      i on r.inventory_id = i.inventory_id 
                 join film_category fc on i.film_id      = fc.film_id
              )
```

<code>any</code> 사용

```sql
select *
  from category c 
 where category_id = any ( select fc.category_id as category_id 
                             from rental r 
                             join inventory       i on r.inventory_id = i.inventory_id 
                             join film_category fc  on i.film_id      = fc.film_id
                         )
```

...

5. dvd 대여를 제일 많이한 고객 이름은 무엇인가요?

```sql
select customer_id , first_name || ' ' || last_name as name 
  from customer c 
 where customer_id in ( select customer_id -- customer_id 148 / count(rental_id) 46
                         from rental r 
                        group by customer_id
                        order by count(rental_id) desc
                        limit 1 
                      )
```

가장 많이 즉, 가장 상위의 데이터를 출력하기 limit을 사용했습니다. 이처럼 데이터가 한 건이 출력될 땐 <code>in</code>을 사용해도 되지만,
<code>=<code>를 사용해도 됩니다.

6. 영화 카테고리값이 존재하지 않는 영화가 있나요?
```sql
select film_id , title
  from film f 
 where film_id not in ( select film_id 
                          from film_category f
                      )
```