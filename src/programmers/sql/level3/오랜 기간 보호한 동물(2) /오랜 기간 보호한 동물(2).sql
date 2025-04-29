SELECT ai.ANIMAL_ID, ai.name
from ANIMAL_INS ai
         join ANIMAL_OUTS ao on ai.ANIMAL_ID = ao.ANIMAL_ID
order by (ao.datetime - ai.datetime) desc
    limit 2
;