select a.AUTHOR_ID,	a.AUTHOR_NAME,	b.CATEGORY, sum(b.PRICE*bs.SALES)	 as TOTAL_SALES
from BOOK b
join AUTHOR a on a.AUTHOR_ID = b.AUTHOR_ID
join BOOK_SALES bs on bs.BOOK_ID =b.BOOK_ID where to_char(bs.SALES_DATE, 'yyyy-mm')='2022-01'
group by a.AUTHOR_ID,	a.AUTHOR_NAME,	b.CATEGORY
order by a.AUTHOR_ID asc, b.CATEGORY desc

