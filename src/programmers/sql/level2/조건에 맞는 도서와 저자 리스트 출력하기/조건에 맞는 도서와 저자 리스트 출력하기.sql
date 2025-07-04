SELECT t1.BOOK_ID,	t2.AUTHOR_NAME	, to_char(t1.PUBLISHED_DATE,'yyyy-mm-dd') as PUBLISHED_DATE
from BOOK t1
         join AUTHOR t2 on t2.AUTHOR_ID= t1.AUTHOR_ID
where t1.CATEGORY ='경제'
order by t1.PUBLISHED_DATE asc