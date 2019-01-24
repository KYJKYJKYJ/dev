--의견글 테이블
create table discuss(
  num number constraint discuss_num_pk primary key,
  title varchar2(200),
  content varchar2(1000) 
)

-- 의견글 시퀀스
create sequence discuss_seq 
start with 1
increment by 1
nocache
nocycle;

insert into discuss values(discuss_seq.nextval,'의견글1','의결을 올려주세요.');
insert into discuss values(discuss_seq.nextval,'여행지선택','여행하고 싶은곳을 의견주세요.');

--댓글 테이블
create table comm(
  col number,
  num number ,
  content varchar2(1000),
constraint bbb_nick_fk foreign key(num) references discuss(num)
)


--댓글 시퀀스
create sequence comm_seq 
start with 1
increment by 1
nocache
nocycle;

insert into comm values(comm_seq.nextval,1,'동의합니다');
insert into comm values(comm_seq.nextval,1,'반대합니다.');

insert into comm values(comm_seq.nextval,2,'미얀마를 추천합니다.');
insert into comm values(comm_seq.nextval,2,'태국을 추천합니다.');

select * from discuss;
select * from comm;