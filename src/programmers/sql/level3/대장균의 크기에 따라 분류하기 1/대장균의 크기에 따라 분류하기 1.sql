-- 코드를 작성해주세요
select id,
       case
           when SIZE_OF_COLONY<=100 then 'LOW'
           when SIZE_OF_COLONY>1000 then 'HIGH'
           else 'MEDIUM'
           end size
from ECOLI_DATA
order by id;