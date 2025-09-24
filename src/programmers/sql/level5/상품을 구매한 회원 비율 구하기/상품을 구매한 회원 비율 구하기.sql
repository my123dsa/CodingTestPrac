with join_user as(
    SELECT *
    FROM USER_INFO ui
    where extract(year from ui.JOINED)= 2021
),
t1 as(
    SELECT ju.user_id,
        extract(year from os.SALES_DATE) as year,
        extract(month from os.SALES_DATE) as month
    FROM join_user ju
    join ONLINE_SALE os  on ju.user_id = os.user_id
    group by ju.user_id,extract(year from os.SALES_DATE),extract(month from os.SALES_DATE)
),
t2 as(
select year,month, count(*) as PURCHASED_USERS
from t1
group by year,month
),
t3 as(
    select count(*) as count
    from join_user
)
select
    t2.year,
    t2.month,
    t2.purchased_users,
    ROUND(t2.PURCHASED_USERS / t3.count, 1) as PUCHASED_RATIO
from t2, t3
order by year,month