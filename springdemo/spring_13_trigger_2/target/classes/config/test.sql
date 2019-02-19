https://blog.naver.com/sky011shin/40054651253

https://blog.naver.com/hjs4827/90118847295

http://rongscodinghistory.tistory.com/109

drop table item;

--��ǰ���̺�
create table item(
  code varchar2(6) primary key, -- ��ǰ �ڵ�
  name varchar2(15) not null,--��ǰ��
  company varchar2(15),--������
  price number(8),--�Һ��ڰ���
  cnt number default 0 -- ��� ����
);

select price from item where code='c0001'
select * from item where code='c0001'
select * from sales
select * from warehouse
delete from sales where num>=4

--��ǰ�߰�
insert into item(code,name,company,price) values('c0001','��ǳ��','�Ｚ',100000);
insert into item(code,name,company,price) values('c0002','������','LG',50000);

drop table warehouse;
--�԰����̺�
create table warehouse(
  num number(6) primary key, --��ǰ �԰� ��ȣ
  code varchar2(6),-- ��ǰ�ڵ�
  indate date default sysdate, -- �԰� ��¥
  incnt number(6),--�԰����
  inprice number(6),--�԰�ܰ�
  constraint fk_code foreign key(code) references item(code)
);

--�԰����̺� ������
create sequence tb_insert_seq
start with 1
increment by 1
nocache
nocycle;

drop table sales;
--�Ǹ����̺�
create table sales(
num number(6) primary key, --�ǸŹ�ȣ
code varchar2(6) not null  , --��ǰ�ڵ�
sadate date default sysdate,--�Ǹ�����
sacnt number(6),--�Ǹż���
saprice number(6),--�ǸŴܰ�
constraint fk_code2 foreign key(code) references item(code) 
);

--�Ǹ����̺� ������
create sequence sa_insert_seq
start with 1
increment by 1
nocache
nocycle;

--â��(warehouse)�� ��ǰ�� �԰�� ������ ��ǰ(item)�� ������ �þ����
-- [������ ������ ���� Ʈ���� ����]
create or replace trigger cnt_add
after insert on warehouse
for each row -- �� row���� �ݺ��Ѵٴ� �ǹ�
  begin
    update item set cnt = cnt + :new.incnt -- new ������ insert��,update�������� ��밡��
    -- newŰ���带 ���� warehouse ���̺� �����Ϳ������� �� �ְ�, warehouse ���̺� insert�۾��� �̷���� ����
    -- �����͸� ������ �´ٴ� �ǹ��̴�.(new)
    where code = :new.code;
  end;
/


insert into warehouse(num, code, incnt, inprice)
values(tb_insert_seq.nextval,'c0001',2,100000);

select * from item;
select * from warehouse;

--�Ǹ����̺��� insertƮ���Ÿ� �ۼ�(BEFOREƮ���ŷ� �ۼ�)
--[�Ǹ����̺극�� �ڷᰡ �߰��Ǵ� ��� ��ǰ���̺��� �������� ����ǵ��� Ʈ���� �ۼ�
create or replace trigger trg_sales_insert
  before insert on sales
  for each row
begin
  update item
  set cnt=cnt-:NEW.sacnt
  where code=:NEW.code;
  end;
 /

 
insert into sales(num,code,sacnt,saprice)
values(sa_insert_seq.nextval,'c0001',1,
	 (select price*1 from item  
	  where code='c0001'));

select * from item;
select * from sales;
update item set cnt=100 where code='c0001'
select price from item where code='c0001';

////////////////////////////////////////////////////////


 
-- â���� ��ǰ�� ������ ������ ������ ���̴� Ʈ����
create or replace trigger cnt_sub
after delete on warehouse
for each row
  begin
    -- delete������ new�� �ƴ� old�� ����ؾ� ��
    -- delete�۾��� �ݿ��ǰ� �������� �����Ͱ� ���� ������ �ݿ��� incnt���� �����ϱ�
    update item set cnt = cnt - :old.incnt
    where code = :old.code;
  end;
/
 
delete from warehouse where code = 'c0001';
select * from item;
select * from sales;


-- **update**
  -- ���� ����
create or replace trigger cnt_update
after update on warehouse
  for each row
    begin
      -- +- �� +�� - �۾��� �� �� ���شٴ� �ǹ�
      --  update item set cnt = cnt +- :old.incnt + :new.incnt -- ������ incnt���� ���ְ�, ���ο� incnt���� �����شٴ� �ǹ�
      -- ex) ������ incnt���� 5�� �־����� ������ �־��� 5�� ���ְ� ���� �Էµ� 7�� �������ֱ� ���� 7�� ���Ѵٴ� �ǹ� 5-5+7
      -- ������ ���� ���ְ� �� ���� �ݿ����ֵ��� update�� ¥���Ѵ�.
    --  where code = :new.code;
       
     -- update item set cnt = cnt - :old.incnt + :new.incnt where code = :new.code;
      update item set cnt = :new.incnt where code = :new.code;
    end;
/
 
update warehouse set incnt = 11, inprice = 800000 where code = 'c0001';
select * from warehouse;
select * from item;
 
 
-- ������ �̿��� EX)
Create Trigger testTrigger
    after insert or update or delete -- ����, ������Ʈ, ���� �� �ϳ� �߻� ���Ŀ� ����
    on emp -- emp ���̺� ����
    for each row -- DML�۾��� ���� ����� ������ Ʃ��(��)�� ���ؼ�
    when (:new.sal > :old.sal) -- ���� ����� sal�� �������� sal���� ū Ʃ�ÿ� ���ؼ���
    -- �Ʒ��� �۾��� �����϶�.
    BEGIN
        if (inserting) then dbms_output.put_line('inserting'); -- �����̸�
        elsif (updating) then dbms_output.put_line('updating'); -- �����̸�
        elsif (deleting) then dbms_output.put_line('deleting'); -- �����̸�
        end if;
    END;
/
     
    -- ����, DML�� ���� ����� ��� Ʃ�õ� �߿� when�� ���ǿ� �ش��ϴ� Ʃ��(��)�鿡
    -- ~�۾��� �ϵ��� �Ǵ� ��


update item set cnt=0 where code='c0001';
    
select * from item;
select * from warehouse;

commit;