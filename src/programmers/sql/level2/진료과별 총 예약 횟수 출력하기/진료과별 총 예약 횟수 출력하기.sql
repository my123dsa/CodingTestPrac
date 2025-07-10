SELECT MCDP_CD as 진료과코드, count(*) as "5월예약건수"
from APPOINTMENT
where to_char(APNT_YMD,'yyyy-mm') = '2022-05'
group by MCDP_CD
order by "5월예약건수" asc, 진료과코드 asc
