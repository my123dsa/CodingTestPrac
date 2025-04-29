-- 코드를 입력하세요
SELECT ai.ANIMAL_ID	,ai.ANIMAL_TYPE	,ai.NAME
from ANIMAL_INS ai
         right join ANIMAL_OUTS ao on ai.animal_id = ao.animal_id
where ao.SEX_UPON_OUTCOME in ('Spayed Female' ,'Neutered Female','Spayed Male' ,'Neutered Male')
  and ai.SEX_UPON_INTAKE not in ('Spayed Female' ,'Neutered Female','Spayed Male' ,'Neutered Male')
