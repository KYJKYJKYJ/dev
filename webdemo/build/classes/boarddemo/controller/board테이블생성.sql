##############################################
게시판 만들기
##############################################

1. 테이블생성 
create table board(
   	num number,
   	writer varchar2(20),
 	email varchar2(30),
	subject varchar2(50),
	reg_date date,
	readcount number default 0, 
	ref number, 
	re_step number, 
	re_level number, 
	content varchar2(100),
	ip varchar2(20),
        upload varchar2(300)
);

create sequence board_num_seq start with 1 increment by 1;

insert into board 
values(board_seq.nextval, '홍길동','young@aaaa.com','제목1',sysdate,0,board_seq.nextval,
0,0,'내용 테스트.......','127.0.0.1','sample.txt');

commit

select * from board;

가장 최근에 입력한 것을 가장 먼저 출력하기 위해서.. 이런식으로 저장한다
          num    ref     re_step    re_level
제목     1        1           0             0
제목     2        2           0             0
답변     3        1           2             1
답변     4        1           1             1

제목     2        2           0             0
제목     1        1           0             0
답변     4        1           1             1
답변     3        1           2             1


select num, ref, re_step, re_level
from board
where ref=30

delete from board;

select b.*
from (select rownum as rm, a.*
from (select * from board 
      order by ref desc,re_step asc)a)b
 where b.rm>=1 and b.rm<=5
    



select b.* from 
(select rownum as rm, a.* from(
  select num, ref, re_step,re_level from board
  order by ref desc, re_step asc) a)b
where b.rm >=1  and b.rm<=5

delete from board where num=23;

WebServlet("/board/*")


webContent             /boardview/list.jsp
boardview
  list.jsp

select count(*) from board where subject like '%w%'
select count(*) from board where writer like '%3%'




select num, ref, re_step,re_level 
from board 
order by num

from -> where -> group by ->having ->select -> order by

select rownum, b.*
 from(select rownum as rm, a.*
 from(select * from board order by ref desc ,re_step asc)a)b
 where b.rm>=? and b.rm <=?





























