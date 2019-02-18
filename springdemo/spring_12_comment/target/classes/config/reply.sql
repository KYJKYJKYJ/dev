drop table tbl_board;
drop table tbl_reply;
drop sequence board_bno_seq;
drop sequence reply_rno_seq;

create table tbl_board(
bno number,
title varchar2(200),
content varchar2(2000),
writer varchar2(50),
regdate date,
viewcnt number default 0);

create table tbl_reply(
 rno number,
 bno number,
 replytext varchar2(1000),
 replyer varchar2(50),
 regdate date
);

create sequence board_bno_seq 
start with 1
increment by 1
nocache
nocycle;

create sequence reply_rno_seq
start with 1
increment by 1
nocache
nocycle;

insert into TBL_BOARD values(board_bno_seq.nextval,'����Ʈ1','����1','�̻�',sysdate,0);
insert into TBL_BOARD values(board_bno_seq.nextval,'����Ʈ2','����2','�̻�2',sysdate,0);
select * from tbl_board;

insert into tbl_reply values(reply_rno_seq.nextval,1,'��۳���1','kim',sysdate);
insert into tbl_reply values(reply_rno_seq.nextval,1,'��۳���2','park',sysdate);
insert into tbl_reply values(reply_rno_seq.nextval,1,'��¥ �׽�Ʈ','son','19-11-23');
select * from tbl_reply
where bno=2;

select * from tbl_reply
order by rno desc;

select b.*, r.* 
from tbl_board b, tbl_reply r
where b.bno=r.bno(+)
      and b.bno=1;
      
delete from tbl_reply;     
select rupload from tbl_reply 
where rno=82
order by rno desc;
select * from tbl_reply;

alter table tbl_reply 
add  rupload varchar2(1000);


commit;



