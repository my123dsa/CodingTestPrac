WITH result1 AS (
    SELECT
        USER_ID,
        PRODUCT_ID,
        SALES_AMOUNT,
        SALES_DATE
    FROM ONLINE_SALE
    WHERE TO_CHAR(SALES_DATE, 'yyyy-mm') = '2022-03'
),
     result2 AS (
         SELECT
             NULL AS USER_ID,
             PRODUCT_ID,
             SALES_AMOUNT,
             SALES_DATE
         FROM OFFLINE_SALE
         WHERE TO_CHAR(SALES_DATE, 'yyyy-mm') = '2022-03'
     )

SELECT
    TO_CHAR(SALES_DATE, 'yyyy-mm-dd') AS SALES_DATE,
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
FROM (
         SELECT * FROM result1
         UNION ALL
         SELECT * FROM result2
     ) re
ORDER BY
    SALES_DATE ASC,
    PRODUCT_ID ASC,
    USER_ID ASC;
