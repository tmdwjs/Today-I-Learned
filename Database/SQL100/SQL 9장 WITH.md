> WITH 절에 대해 학습합니다.

<code>WITH</code>절은 복잡한 SQL에서 동일 블록에 대해 반복적으로 사용하는 경우 이름을 부여해 재사용성을 증가시켜 쿼리 성능 향상에 도움을 줍니다.

2. 영화 시간 유형에 따라 영화 수를 구해주세요. 영화 상영 시간에 따른 유형은 다음과 같이 정의됩니다.
60분 이하 short , 61분 이상 120분 이하 middle , 121분 이상 long

```sql
with tbl as ( select 0   as chk1 , 60  as chk2 , 'short'  as length_type
			  union all
			  select 61  as chk1 , 120 as chk2 , 'middle' as length_type
			  union all
			  select 121 as chk1 , 999 as chk2 , 'long'   as length_type
  		     )

select db.length_type
	 , count(db.film_id) as length_flag
  from ( select *
  		   from film f 
  		   		join tbl on f.length between chk1 and chk2
	   ) as db
 group by db.length_type
```

이는 WITH절을 사용하지 않고도 더 짧게 쿼리문 작성이 가능합니다.

```sql
select aa.flag, count(aa.film_id)
  from ( select *
			  , case 
			 		when f.length <= 60 			 then 'short'
			 		when f.length between 61 and 120 then 'middle'
			 		else 								  'long'
			    end as flag
		  from film f 
  	   ) as aa
 group by aa.flag
```

해당 파트에서는 WITH절에 대한 개념만 잡는 데 초점을 뒀기 때문에, 예제 문제는 WITH절을 사용하지 않았을 때 길이가 더 짧을 수 있습니다.

보통 WITH절은 프로시저와 함께 사용이 됩니다. 하지만 요즘은 비즈니스 로직을 WAS에서 작성하고 DB 의존성을 낮추기 위해 프로시저를 지양하고 있습니다.
따라서 해당 파트는 WITH절에 대한 개념만 짚고 넘어가는 걸로 마무리하겠습니다.