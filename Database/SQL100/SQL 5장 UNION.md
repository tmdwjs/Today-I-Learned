> UNION, UNION ALL, INTERSECT, EXCEPT에 대해 학습합니다.

1. 영화 배우가, 영화 180분 이상의 길이의 영화에 출연하거나, 영화의 rating이 R인 등급에 해당하는 영화에 출연한 영화 배우에 대해서, 영화 배우 ID와 (180분 이상 / R 등급 영화)에 대한 Flag 컬럼을 알려주세요. actor_id가 동일한 flag 값이 여러 개 나오지 않도록 해주세요.

```sql
select fa.actor_id as actor_id 
     , 'Y' as "180분이상 / R등급"
  from film_actor fa 
  join film f on fa.film_id = f.film_id 
 where f.rating = 'G'
 
union
 
select fa.actor_id as actor_id
     , 'Y' as "180분이상 / R등급"
  from film_actor fa 
  join film f on fa.film_id = f.film_id 
 where f.length = 116
 
order by actor_id
```

2.  R등급의 영화에 출연했던 배우이면서, 동시에 Alone Trip의 영화에 출연한 영화배우의 ID를 확인해 주세요.

```sql
select fa.actor_id as actor_id
  from film_actor fa 
  join film f on fa.film_id = f.film_id 
 where f.rating = 'G'

intersect

select fa.actor_id as actor_id
  from film_actor fa 
  join film f on fa.film_id = f.film_id 
 where f.title = 'Alone Trip'
 
 order by actor_id
```

<code>intersect</code>는 교집합을 추출 즉, AND 조건의 데이터를 추출할 때 사용됩니다.

...

4. 필름 중에서, 필름 카테고리가 Action, Animation, Horror에 해당하지 않는 필름 아이디를 알려주세요.

```sql
select count(*) -- 814
  from ( select fc.film_id as film_id , c."name" 
           from category c 
           join film_category fc on c.category_id = fc.category_id 
      
         except
   
        select fc.film_id as film_id , c."name" 
          from category c 
          join film_category fc on c.category_id = fc.category_id 
         where c.name in ( 'Action', 'Animation', 'Horror' )
   
         order by film_id ) as db
```

<code>except</code>는 차집합입니다. 전체 쿼리 중, 두 번째로 오는 쿼리에 해당하지 않는 데이터를 출력합니다.

해당 예제는 <code>except</code>를 사용하지 않고 <code>not in</code> 통해 구할 수도 있습니다.

```sql
select count(*) -- 814
  from category c 
  join film_category fc on c.category_id = fc.category_id 
 where c.name not in ('Action', 'Animation', 'Horror')
```

...

10. 국가(country)별 도시(city)별 매출액, 국가(country)매출액 소계, 그리고 전체 매출액을 구해주세요.

```sql
select c3.country_id as country_id
     , c2.city_id    as city_id
     , sum(p.amount) as sum_amount         
  from payment p  
  join customer c on p.customer_id = c.customer_id 
  join address  a on c.address_id  = a.address_id 
  join city    c2 on a.city_id     = c2.city_id 
  join country c3 on c2.country_id = c3.country_id
 group by c3.country_id , c2.city_id
 
union all 

select c3.country_id as country_id
     , null          as city_id
     , sum(p.amount) as sum_amount          
  from payment p  
  join customer c on p.customer_id = c.customer_id 
  join address  a on c.address_id  = a.address_id 
  join city    c2 on a.city_id     = c2.city_id 
  join country c3 on c2.country_id = c3.country_id
 group by c3.country_id
 
union all 
 
select null          as country_id
     , null          as city_id
     , sum(p.amount) as sum_amount          
  from payment p  
  join customer c on p.customer_id = c.customer_id 
  join address  a on c.address_id  = a.address_id 
  join city    c2 on a.city_id     = c2.city_id 
  join country c3 on c2.country_id = c3.country_id
```