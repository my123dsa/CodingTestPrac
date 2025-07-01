-- 코드를 입력하세요
with data as(
    SELECT car_id, round(avg(end_date-start_date+1),1) as len
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    group by car_id
)
select car_id, TO_CHAR(len, 'FM9999990.0') AS AVERAGE_DURATION
from data
where len>=7
order by len desc,car_id desc