> ORDER BY와 LIKE, NULL, LIMIT과 같은 데이터 필터링에 대해 학습합니다.

1. film 테이블을 활용하여, film 테이블의 100개의 row만 확인해 보세요.

```sql
select *
  from film
 limit 100
```

이처럼 단순 row의 개수를 지정해 출력하고 싶을 땐 <code>limit</code>를 사용해 지정할 수 있습니다.
예를 들어, 할인율이 가장 큰 프로모션 한 개의 데이터만 전송하는 경우가 있습니다.

2. actor의 성이  Jo로 시작하는 사람의 id 값이 가장 낮은 사람 한사람에 대하여, 사람의  id 값과  이름, 성을 알려주세요.

```sql
select actor_id
	 , first_name 
	 , last_name 
  from actor
 where last_name like 'Jo%'
 order by actor_id
 limit 1
```

<code>like</code>는 문자열에서만 사용이 가능합니다. 따라서 숫자와 문자를 비교하고 싶으면, 숫자를 형변환 해 비교해 줄 수 있습니다.
형변환은 <code>cast()</code> 메서드를 사용해 변환이 가능합니다.

```sql
select actor_id , first_name , last_name 
  from actor a 
 where cast(actor_id as text) like '1%'
 order by actor_id 
 limit 1;
```

