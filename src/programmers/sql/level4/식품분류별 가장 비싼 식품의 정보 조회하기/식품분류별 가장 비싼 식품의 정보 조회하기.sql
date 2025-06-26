-- 코드를 입력하세요
select  fp.CATEGORY,  MAX_PRICE, fp.PRODUCT_NAME
from FOOD_PRODUCT fp
         join
     (
         SELECT fp.CATEGORY, max(price) as MAX_PRICE
         from FOOD_PRODUCT fp
         where fp.category in ('과자', '국', '김치', '식용유')
         group by fp.CATEGORY
     ) result  on fp.CATEGORY= result.CATEGORY and fp.price =result.MAX_PRICE
order by max_price desc
