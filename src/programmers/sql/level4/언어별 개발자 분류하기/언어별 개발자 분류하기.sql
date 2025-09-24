with result as(
    select d.id,
    case
        when max(CASE WHEN s.name = 'Python' THEN 1 END)=1 and
            max(CASE WHEN s.CATEGORY = 'Front End' THEN 1 END)=1
            THEN 'A'
        when max(case when s.name = 'C#' then 1 end) THEN 'B'
        when max(case when s.category = 'Front End' then 1 end) =1 THEN 'C'
    END AS grade
    from DEVELOPERS d
    join SKILLCODES s
    on (s.CODE & d.SKILL_CODE) >0
    group by d.id
)
select r.GRADE,	d.ID,d.EMAIL
from DEVELOPERS d
join result r on r.id = d.id
where r.grade is not null
order by GRADE,id
