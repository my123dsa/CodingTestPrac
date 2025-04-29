-- 코드를 입력하세요
SELECT ao.animal_id,ao.name
from ANIMAL_INS ai
         right join ANIMAL_OUTS ao on ai.animal_id=ao.animal_id
where ai.ANIMAL_ID is null
