SELECT
    id,
    CASE
        WHEN (row_num / total_count) > 0.75 THEN 'CRITICAL'
        WHEN (row_num / total_count) > 0.50 THEN 'HIGH'
        WHEN (row_num / total_count) > 0.25 THEN 'MEDIUM'
        ELSE 'LOW'
        END AS COLONY_NAME
FROM (
         SELECT
             id,
             ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY) AS row_num,
                 COUNT(*) OVER () AS total_count
         FROM
             ECOLI_DATA
     ) AS sub
ORDER BY id;