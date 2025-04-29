-- 코드를 입력하세요
SELECT ai.NAME	,ai.DATETIME
from ANIMAL_INS ai
         left join ANIMAL_OUTS ao on ai.animal_id =ao.animal_id
where ao.animal_id is null
order by ai.DATETIME asc
    limit 3;
