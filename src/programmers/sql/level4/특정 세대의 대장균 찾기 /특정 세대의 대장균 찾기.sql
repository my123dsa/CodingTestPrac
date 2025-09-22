WITH gen AS (
    SELECT ID,
           PARENT_ID,
           CASE
             WHEN PARENT_ID IS NULL THEN 1
             ELSE 0
           END AS g
    FROM ECOLI_DATA
),
gen2 AS (
    SELECT e1.id,
           e1.PARENT_ID,
           CASE
             WHEN gen.g = 1 THEN 2
             ELSE gen.g
           END AS g2
    FROM ECOLI_DATA e1
    JOIN gen ON e1.parent_id = gen.id
),
gen3 AS (
    SELECT e1.id,
           e1.PARENT_ID,
           CASE
             WHEN gen2.g2 = 2 THEN 3
             ELSE gen2.g2
           END AS g3
    FROM ECOLI_DATA e1
    JOIN gen2 ON e1.parent_id = gen2.id
)
SELECT id
FROM gen3
where g3 = 3
order by id asc;


# or 반복문 사용 버전

with recursive gen as(
    select id,parent_id, 1 as depth
    from ECOLI_DATA
    where parent_id is null

    union all
    select e.id,e.parent_id ,g.depth +1 as depth
    from ECOLI_DATA e
    join gen g on e.parent_id = g.id
)

select id
from gen
where depth =3
order by id asc