-- 코드를 입력하세요
with max_table as(
    SELECT FOOD_TYPE,max(FAVORITES) as max
    from REST_INFO
    group by FOOD_TYPE
)
select t1.FOOD_TYPE,	t1.REST_ID,	t1.REST_NAME,	t1.FAVORITES
from REST_INFO t1
         join max_table on t1.food_type = max_table.food_type and t1.FAVORITES= max_table.max
order by t1.food_type desc