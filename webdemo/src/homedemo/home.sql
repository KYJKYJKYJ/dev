select a.* from
(select * from employees order by employee_id)a
where rownum<=5;


