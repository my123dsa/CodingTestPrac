-- 코드를 입력하세요
select
    month(start_date) as MONTH,
    t1.car_id,
    count(t1.HISTORY_ID) as RECORDS
from
    (
    SELECT car_id, count(HISTORY_ID)
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where year(START_DATE)=2022 and month(START_DATE)>=8 and month(START_DATE)<=10
    group by car_id
    having count(HISTORY_ID)>=5
    ) as result,
    CAR_RENTAL_COMPANY_RENTAL_HISTORY as t1
where t1.car_id = result.car_id and
    year(t1.START_DATE)=2022 and month(t1.START_DATE)>=8 and month(t1.START_DATE)<=10
group by  month,t1.car_id
order by month,car_id desc;