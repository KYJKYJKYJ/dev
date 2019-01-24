공지사항 - employees - employee_id, first_name
질문과 답변 - Departments - department_id, department_name
저자문의 - locations - location_id, city


select rownum ,  A.* from (
			select  employee_id as num , first_name as title from employees order by employee_id desc
) A
where rownum<=5
union all
select rownum , 'dep' as gubun , B.* from (
			select  department_id as num , department_name as title from Departments order by department_id desc
) B
where rownum<=5
union all
select rownum , 'loc' as gubun , C.* from (
			select  location_id as num , city as title from locations order by location_id desc
) C
where rownum<=5

공지사항 - employees - employee_id, first_name, hire_date
질문과 답변 - board - num, subject, reg_date
저자문의 - mem - num, name, age 

select rownum , 'emp' as gubun,  A.* from (
			select  employee_id as num , first_name as title from employees order by employee_id desc
) A
where rownum<=5


select rownum ,  A.* from (
			select  num, subject, reg_date from board order by reg_date desc
) A
where rownum<=5

select rownum ,  A.* from (
			select  num, name, age from mem order by num desc
) A
where rownum<=5


select * from board;
select * from employees;
select * from mem;


