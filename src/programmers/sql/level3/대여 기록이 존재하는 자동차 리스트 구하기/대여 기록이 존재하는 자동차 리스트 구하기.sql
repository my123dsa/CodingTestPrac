-- 코드를 입력하세요
SELECT t1.car_id
from CAR_RENTAL_COMPANY_CAR t1
         join CAR_RENTAL_COMPANY_RENTAL_HISTORY t2 on t1.CAR_ID= t2.CAR_ID
where t1.CAR_TYPE='세단'
  and to_char(START_DATE,'mm')=10
group by t1.car_id
order by t1.CAR_ID desc

