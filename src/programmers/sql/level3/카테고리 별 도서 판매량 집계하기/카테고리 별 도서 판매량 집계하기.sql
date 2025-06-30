-- 코드를 입력하세요
SELECT b.CATEGORY, sum(bs.SALES) as TOTAL_SALES
from BOOK b
         join BOOK_SALES bs on b.book_id = bs.book_id
where to_char(bs.SALES_DATE,'yyyy-mm') = '2022-01'
group by b.CATEGORY
order by b.category