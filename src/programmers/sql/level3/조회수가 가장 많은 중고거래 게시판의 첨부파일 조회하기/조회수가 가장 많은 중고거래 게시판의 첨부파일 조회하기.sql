-- 코드를 입력하세요
select ('/home/grep/src/'|| t2.BOARD_ID ||'/' || FILE_ID ||  FILE_NAME || FILE_EXT )as FILE_PATH
from
    (
        SELECT t1.BOARD_ID, row_number() over(order by t1.VIEWS desc) as rank
        from USED_GOODS_BOARD t1
    ) result
        join USED_GOODS_FILE t2 on result.BOARD_ID = t2.BOARD_ID
where result.rank =1
order by t2.FILE_ID desc


