create table phonebook_tb (
    name varchar2(30) primary key,
    phonenumber varchar2(30),
    birthday varchar2(30)
);

create sequence seq_phonebook 
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;

-- �Է�
insert into phonebook_tb values ('���Ѽ�', '010-6775-5529', '930427');

-- �˻�
select * from phonebook_tb where name like '���Ѽ�';

-- ����
delete from phonebook_tb where name = '���Ѽ�';