with result as(
SELECT ui.USER_ID,extract(year from os.SALES_DATE) as YEAR,
    extract(month from os.SALES_DATE) as MONTH,
    ui.GENDER as GENDER
from USER_INFO ui
join ONLINE_SALE os on ui.USER_ID= os.USER_ID and ui.GENDER is not null
group by ui.USER_ID,extract(year from os.SALES_DATE), extract(month from os.SALES_DATE),ui.GENDER
)
select year,
    month,
    gender,
    count(*) as USERS
from result
group by year,month,gender
order by year,month,gender
