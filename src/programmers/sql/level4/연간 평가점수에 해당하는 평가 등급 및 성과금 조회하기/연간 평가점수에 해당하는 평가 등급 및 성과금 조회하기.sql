select hg.EMP_NO,he.EMP_NAME,
case
    when avg(score)>=96 then 'S'
    when avg(score)>=90 then 'A'
    when avg(score)>=80 then 'B'
    else 'C'
end
as GRADE,
case
    when avg(score)>=96 then  he.SAL*0.2
    when avg(score)>=90 then  he.SAL*0.15
    when avg(score)>=80 then  he.SAL*0.1
    else  0
end
as BONUS
from HR_DEPARTMENT hd
join HR_EMPLOYEES he on hd.DEPT_ID= he.DEPT_ID
join HR_GRADE hg on hg.EMP_NO= he.EMP_NO
group by hg.EMP_NO,he.EMP_NAME,he.SAL
order by hg.EMP_NO asc