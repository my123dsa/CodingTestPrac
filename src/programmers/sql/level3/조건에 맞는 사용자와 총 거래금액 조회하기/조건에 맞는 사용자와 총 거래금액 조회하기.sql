SELECT t2.user_id,t2.nickname,sum(PRICE) as TOTAL_SALES
from USED_GOODS_BOARD t1
         join USED_GOODS_USER t2 on t1.WRITER_ID = t2.USER_ID
where t1.STATUS='DONE'
group by t2.user_id,t2.nickname
having sum(PRICE)>=700000
order by TOTAL_SALES