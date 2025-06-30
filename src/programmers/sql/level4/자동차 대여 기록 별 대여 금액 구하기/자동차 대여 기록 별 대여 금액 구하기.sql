-- 코드를 입력하세요
select result2.HISTORY_ID, TRUNC((result2.daily_fee)*(100-nvl(result2.discount_rate,0))/100*result2.day) as fee
from (SELECT *
      from CAR_RENTAL_COMPANY_CAR t1
               join
           (
               select HISTORY_ID,car_id, (END_DATE - START_DATE)+1 AS day,

                      case
                          when (END_DATE-start_date)>=90 then 9
                          when (END_DATE-start_date)>=30 then 3
                          when (END_DATE-start_date)>=7 then 7
                          else 0
                          end as days
               from CAR_RENTAL_COMPANY_RENTAL_HISTORY t2
           ) result on t1.car_id = result.car_id and t1.CAR_TYPE= '트럭'
               left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN t3 on t1.CAR_TYPE= t3.CAR_TYPE
          and result.days = to_number(substr(t3.DURATION_TYPE,1,1))
     ) result2
order by fee desc,result2.HISTORY_ID desc