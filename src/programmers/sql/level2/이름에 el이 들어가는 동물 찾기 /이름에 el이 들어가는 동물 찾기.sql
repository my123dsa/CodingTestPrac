SELECT ANIMAL_ID, NAME
from ANIMAL_INS
where upper(name) like '%EL%' and ANIMAL_TYPE='Dog'
order by name asc;