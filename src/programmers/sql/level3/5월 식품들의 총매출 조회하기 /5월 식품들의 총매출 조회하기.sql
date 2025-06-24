select fr.PRODUCT_ID, fr.PRODUCT_NAME , SUM(fo.AMOUNT * fr.PRICE) as TOTAL_SALES
from  FOOD_PRODUCT fr
join FOOD_ORDER fo on fo.PRODUCT_ID = fr.PRODUCT_ID
where to_char(fo.PRODUCE_DATE,'YYYY-MM')='2022-05'
group by fr.PRODUCT_ID, fr.PRODUCT_NAME
order by TOTAL_SALES desc, fr.PRODUCT_ID asc
;


