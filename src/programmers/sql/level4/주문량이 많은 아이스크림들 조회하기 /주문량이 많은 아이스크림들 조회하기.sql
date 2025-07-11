SELECT FLAVOR
FROM (
         SELECT
             t1.FLAVOR,
             SUM(t1.TOTAL_ORDER + t2.TOTAL_ORDER) AS total,
             ROW_NUMBER() OVER (ORDER BY SUM(t1.TOTAL_ORDER + t2.TOTAL_ORDER) DESC) AS rn
         FROM FIRST_HALF t1
                  JOIN JULY t2 ON t1.FLAVOR = t2.FLAVOR
         GROUP BY t1.FLAVOR
     )
where rn<=3;


