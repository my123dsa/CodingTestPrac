-- 코드를 입력하세요
with result1 as(
    select t1.car_id,t1.CAR_TYPE,t1.DAILY_FEE
    from CAR_RENTAL_COMPANY_CAR t1
    where t1.car_type in('세단','SUV')
      AND NOT EXISTS (
        SELECT 1
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY t2
        WHERE t2.CAR_ID = t1.CAR_ID
          AND (
            (to_char(t2.START_DATE,'yyyy-mm')<= '2022-11' AND to_char(t2.END_DATE,'yyyy-mm')>='2022-11')
            )
    )
    group by t1.car_id,t1.CAR_TYPE,t1.DAILY_FEE
)
SELECT result1.car_id,result1.car_type,trunc((result1.daily_fee*30)*(100-t3.discount_rate)/100) as fee
from result1
         join CAR_RENTAL_COMPANY_DISCOUNT_PLAN t3 on result1.CAR_TYPE = t3.CAR_TYPE and t3.DURATION_TYPE='30일 이상'
where ((result1.daily_fee*(100-t3.discount_rate)/100*30)>=500000) and
    ((result1.daily_fee*(100-t3.discount_rate)/100*30)< 2000000)
order by fee desc,result1.car_type asc,result1.car_id desc

