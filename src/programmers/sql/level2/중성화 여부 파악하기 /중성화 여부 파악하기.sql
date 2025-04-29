-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME,
       case
           when SEX_UPON_INTAKE in( 'Neutered Male','Neutered Femal' ,'Spayed Female','Spayed Male') then 'O'
           else 'X'
           end as '중성화'
from ANIMAL_INS
order by animal_id