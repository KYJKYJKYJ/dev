select * from employees;

select hire_date from employees;

select * from mem

create table mem(
 num number,
 name varchar2(20),
 age  number(3),
 loc varchar2(10));
 
 create sequence mem_num_seq
 start with 1
 increment by 1
 nocache
 nocycle;
 
  insert into mem values(mem_num_seq.nextval, 'È«±æµ¿',30,'¼­¿ï');  
 select * from mem order by num; 
 commit
 
 
 
select e. employee_id, e.first_name, e. job_id, e.department_id 
          ,d. department_name
 from employees e, departments d
 where e.department_id=d.department_id;
 
 
 select d.department_id,d.department_name,
		       e.employee_id, e.first_name
		from departments d,	employees e
		where d.department_id=e.department_id
		order by d.department_id
 
 
 
 
 
 
 
 
 
 