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

-- 입력
insert into phonebook_tb values ('유한솔', '010-6775-5529', '930427');

-- 검색
select * from phonebook_tb where name like '유한솔';

-- 삭제
delete from phonebook_tb where name = '유한솔';