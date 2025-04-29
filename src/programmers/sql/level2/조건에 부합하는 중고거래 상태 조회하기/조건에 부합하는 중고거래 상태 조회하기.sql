SELECT BOARD_ID,WRITER_ID,title,price,
       case
           when STATUS='SALE' then '판매중'
           when STATUS='RESERVED' then '예약중'
           else '거래완료'
           end as status
from USED_GOODS_BOARD
where year(CREATED_DATE)=2022 and month(CREATED_DATE)=10 and day(CREATED_DATE)=5
order by board_id desc;