alter table buytbl drop foreign key buytbl_ibfk_1;

drop table if exists usertbl;
create table usertbl(
userID char(8) not null,
name varchar(10) not null,
birthYear int not null,
constraint primary key PK_userTBL_userID(userID)
);

-- prodtbl 정의
drop table if exists prodtbl;

 create table prodtbl(
 prodCode char(3) not null,
 prodID char(4) not null,
 prodDate datetime not null,
 prodCur char(10) null,
 constraint PK_prodtbl_prodCode_prodID
 primary key (prodCode, prodID) -- 복합키로 기본키 설정
 );
 
 -- usertbl과 buytbl을 바탕으로 다음 결과가 나오는 뷰를 정의하세요.
 use sqldb;
 create view v_userbuytbl
 as select u.userid, u.name, b.prodName, u.addr, concat(u.mobile1, u.mobile2) as '연락처'
 from usertbl u inner join buytbl b on u.userid=b.userid;
 
 select * from v_userbuytbl where name='김범수';
 
 -- 실습 문제
 
 create database recruitDB;
 use recruitDB;
 
 -- 1
 create table departments (
 dept_id int not null primary key,
 dept_name varchar(30) not null
 ) ;
 
 -- 2
 create table applicants (
 applicant_id int primary key,
 name varchar(50) ,
 email varchar(50) unique key,
 phone varchar(15),
 dept_id int,
 apply_date date,
 foreign key(dept_id) references departments(dept_id)
 );
 
 -- 3
 alter table applicants
 modify column apply_date datetime default current_timestamp;
 
 -- 4
 alter table applicants
 add check(length(name) between 2 and 20);
 
 -- 4
 alter table applicants
 add check(length(phone) between 10 and 13);
 
 -- 5
 insert into departments(dept_id, dept_name) values (1, '개발팀');
  insert into departments(dept_id, dept_name) values (2, '인사팀');
  insert into departments(dept_id, dept_name) values(3, '마케팅팀');
  
  -- 6
  insert into applicants(applicant_id, name, email, phone, dept_id, apply_date)
  values (101, '김지은', 'jkim@example.com', '01012345678', 1, default), 
  (102, '이현수', 'hyunlee@example.com', '01098765432', 2, default);
  
  -- 7
  insert into applicants(applicant_id, name, email, phone, dept_id, apply_date)
  values(103, '최은비', 'jkim@example.com','01022223333', '99', default);
  
  -- 9
  update applicants set name='김지혜' where applicant_id=101;
 
 -- 10
 update departments set dept_name='연구개발팀' where dept_id=1;
 
 -- 11
 alter table applicants
 add column is_inerviewed boolean default 0;
 
 -- 12
 alter table applicants
 drop column phone; 
 
 -- 13
ALTER TABLE applicants
DROP CHECK applicants_chk_1;

-- 제약조건명 확인
SELECT CONSTRAINT_NAME
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_NAME = 'applicants'
  AND CONSTRAINT_TYPE = 'CHECK'
  and table_schema = 'name';
  

alter table applicants
change column name applicant_name varchar(100);

alter table applicants
add constraint chk_applicant_name_length
check(length(applicant_name) between 2 and 20);
  
  -- 14
  show create table applicants; -- applicants_ibfk_1

-- 15
create view vw_applicant_summary
as select applicant_id, applicant_name, email, dept_id, apply_date from applicants;
  
-- 16
create view vw_dev_applicants
as select a.applicant_name, a.email, d.dept_name from applicants a inner join departments d
on a.dept_id=d.dept_id
where dept_name='연구개발팀';

drop view vw_dev_applicants;

-- 17
create view vw_h_email_applicants
as select applicant_name, email, apply_date from applicants
where email like 'h%';

drop view vw_h_email_applicants;

-- 18
select applicant_name, apply_date from vw_applicant_summary;

-- 19
update vw_applicant_summary
set applicant_name='김수진'
where email='jkim@example.com';

-- 20
insert into vw_applicant_summary
values (999, '박지현', 'jhpark@example.com', 1, default);

