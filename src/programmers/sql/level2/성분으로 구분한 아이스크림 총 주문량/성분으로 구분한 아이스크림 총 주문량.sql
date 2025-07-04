SELECT  t2.INGREDIENT_TYPE, sum(t1.TOTAL_ORDER) as total_order
from FIRST_HALF t1
         join ICECREAM_INFO t2 on t1.FLAVOR= t2.FLAVOR
group by t2.INGREDIENT_TYPE
order by total_order asc