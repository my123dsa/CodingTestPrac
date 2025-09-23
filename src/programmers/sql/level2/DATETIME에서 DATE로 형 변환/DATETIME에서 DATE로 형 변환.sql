SELECT ANIMAL_ID,	NAME,
to_char(DATETIME,'yyyy-mm-dd') as 날짜
from ANIMAL_INS
order by animal_id

