select CAR_ID, case when car_id in (select CAR_ID
                                    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                    where start_date <= '2022-10-16' and end_date >= '2022-10-16'
                                    group by car_id
) then '대여중'
                    else '대여 가능' end AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc