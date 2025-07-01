SELECT a.APNT_NO,	p.PT_NAME,	p.PT_NO,	d.MCDP_CD,	d.DR_NAME,	APNT_YMD
from DOCTOR d
         join APPOINTMENT a on d.DR_ID = a.MDDR_ID and a.MCDP_CD ='CS'
    and to_char(APNT_YMD,'yyyy-mm-dd')='2022-04-13'
         join PATIENT p on p.PT_NO= a.PT_NO
where a.APNT_CNCL_YMD is null or a.APNT_CNCL_YN='N'
order by APNT_YMD asc