select * from employees.employees
order by emp_no; -- pk로 정렬하면 0sec로 비용 부담 x

-- 사용자 관리 db 실습
create database scoula_db;

drop user if exists 'scoula'@'%';

create user 'scoula'@'%' identified by '1234';

grant all privileges on scoula_db.* to 'scoula'@'%';
grant all privileges on sqldb.* to 'scoula'@'%';
flush privileges;

-- 트랜잭션 실습
use sqldb;
select * from buytbl;

start transaction;
delete from buytbl where num =1;
delete from buytbl where num = 2;

select * from buytbl;

rollback;

select * from buytbl;    

-- 기본 실습 1
create table tbl1(
a int primary key,
b int,
c int
);

show index from tbl1; -- 인덱스 조회                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           from buytbl;

-- 기본 실습 2
create table tbl2(
a int primary key, -- 클러스터형 인덱스 생성
b int unique, -- 보조 인덱스 생성
c int unique,
d int
);

show index from tbl2;

-- 기본 실습 3
create table tbl3 (
a int unique,
b int unique,
c int unique,
d int
);

show index from tbl3;

-- 기본 실습 4
create table tbl4(
a int unique not null,
b int unique,
c int unique,
d int
);

show index from tbl4;

-- 기본 실습5
create table tbl5(
a int unique not null, -- unique + not null -> 클러스터형 인덱스
b int unique,
c int unique,
d int primary key -- unique + not null과 pk가 둘다 있다면 pk가 클러스터형 인덱스(우선순위 높음)
);

show index from tbl5;

-- 기본 실습 6
create database if not exists testdb;

use testdb;

drop table if exists usertbl;

create table usertbl(
userID char(8) not null primary key,
name varchar(10) not null,
birthYear int not null,
addr nchar(2) not null
);

insert into usertbl values('LSG', '이승기', 1987, '서울');
insert into usertbl values('KBS', '김범수', 1979, '경남');
insert into usertbl values('KKH', '김경호', 1971, '전남');
insert into usertbl values('JYP', '조용필', 1950, '경기');
insert into usertbl values('SSK', '성시경', 1979, '서울');

select * from usertbl;

alter table usertbl drop primary key;

alter table usertbl
add constraint pk_name primary key(name);

select * from usertbl;
show index from usertbl;

-- 오후 실습
-- 1
create database job_platform;
use job_platform;

create table company(
company_id int primary key auto_increment,
company_name varchar(100) not null,
industry varchar(50) null,
founded_year int, 
check(founded_year>=1900)
);


create index idx_company_industry on company(industry);

show index from company;

create table recruit_post(
post_id int primary key auto_increment,
company_id int,
title varchar(100) null,
job_type varchar(20),
deadline date null,
is_active boolean default true,
foreign key (company_id) references company(company_id),
check (job_type in ('정규직', '계약직', '인턴'))
);

show index from recruit_post;

-- 2

insert into company(company_name, industry, founded_year) 
values ('카카오', 'IT', '2010'), ('현대자동차', '제조업', '1967'), ('토스', '핀테크', '2015'), ('쿠팡', '물류/유통', '2010'),('CJ ENM', '미디어', '1995'), ('배달의 민족', 'IT', '2011');

insert into recruit_post (company_id, title, job_type, deadline, is_active) 
values ((select company_id from company where company_name='카카오'), '백엔드 개발자 채용', '정규직', '2025-06-15', 1), 
((select company_id from company where company_name='현대자동차'), '생산관리 신입 모집', '정규직', '2025-06-20', 1), 
((select company_id from company where company_name='토스'), '데이터 분석 인턴', '인턴', '2025-05-31', 1),
((select company_id from company where company_name='카카오'), 'UX 디자이너 계약직', '계약직', '2025-06-10', 0),
((select company_id from company where company_name='쿠팡'), '물류센터 관리자 채용', '정규직', '2025-06-25', 1),
((select company_id from company where company_name='CJ ENM'), '콘텐츠 마케팅 인턴', '인턴', '2025-05-30', 1),
((select company_id from company where company_name='배달의 민족'), '앱 서비스 운영 계약직', '계약직', '2025-06-12', 1),
((select company_id from company where company_name='배달의 민족'), '데이터 엔지니어 채용', '정규직', '2025-06-18', 1),
((select company_id from company where company_name='현대자동차'), '브랜드전략팀 계약직 채용', '계약직', '2025-06-08', 0),
((select company_id from company where company_name='쿠팡'), '풀필먼트 혁신 프로젝트 인턴', '인턴', '2025-05-27', 1);

-- 3
select post_id, title, job_type, deadline, is_active from recruit_post
where is_active=1
order by deadline;

-- 4
select c.company_name, r.title, r.job_type, r.deadline, r.is_active from recruit_post r inner join company c on r.company_id=c.company_id
order by company_name;

-- 5
select c.company_name, c.industry, r.title, r.job_type, r.is_active from recruit_post r inner join company c on r.company_id=c.company_id
where c.industry in ('IT', '핀테크')
order by r.deadline desc;

-- 6
select c.company_name, r.title, r.job_type, r.deadline from recruit_post r inner join company c on r.company_id=c.company_id
where r.deadline between '2025-05-25' and '2025-06-01'
order by deadline ;

-- 7
select c.company_name, r.title, r.job_type, r.deadline, r.is_active from recruit_post r inner join company c on r.company_id=c.company_id
where title like '%데이터%'
order by deadline;

-- 8, 9
select c.company_name, count(company_name) as '공고수' from recruit_post r inner join company c on r.company_id=c.company_id
group by company_name having count(company_name)>=2
order by count(company_name) desc;

-- 10
select r.job_type, count(job_type) as '공고수' from recruit_post r inner join company c on r.company_id=c.company_id
group by job_type
order by count(job_type) desc;

-- 11
select c.company_name, r.title, r.job_type, r.deadline, r.is_active from recruit_post r inner join company c on r.company_id=c.company_id
where c.industry='IT' and job_type='정규직'
order by deadline;

-- 12
INSERT INTO company (company_name, industry, founded_year)
VALUES ('네이버', 'IT', 1999);

select c.company_name, r.title, r.job_type, r.deadline from company c left join recruit_post r on r.company_id=c.company_id
order by company_name;

-- 13
select c.company_name, c.industry, c.founded_year from company c left join recruit_post r on r.company_id=c.company_id
where title is null;

-- 14
INSERT INTO recruit_post (company_id, title, job_type, deadline, is_active)
VALUES (
  (SELECT company_id FROM company WHERE company_name = '카카오'),
  'AI 연구원 채용',
  '정규직',
  '2025-06-28',
  TRUE
);

select c.company_name, c.industry, count(c.company_name) as '공고수' from recruit_post r inner join company c on r.company_id=c.company_id
group by c.company_name, c.industry
order by count(c.company_name) desc limit 1;

-- 15
select c.company_name, count(*) as '공고수' from recruit_post r inner join company c on r.company_id=c.company_id

group by c.company_name
having count(*) in (1,2) and sum(is_active=1)=count(*)
order by count(*) desc;

-- 16
select company_name, industry, founded_year from company
where company_id in (select company_id from recruit_post where is_active>=1)
order by company_name;

-- 17
INSERT INTO company (company_name, industry, founded_year)
VALUES ('삼성전자', '전자', 1969);

select c.company_name, c.industry, c.founded_year from company c left join recruit_post r on r.company_id=c.company_id
where title is null;

-- 18
-- ① 외래키 제약 해제
SET FOREIGN_KEY_CHECKS = 0;

-- ② 존재하지 않는 company_id를 참조하는 테스트 공고 삽입
INSERT INTO recruit_post (company_id, title, job_type, deadline, is_active)
VALUES (999, '테스트용 유효하지 않은 공고', '정규직', '2025-07-01', TRUE);

-- ③ 외래키 제약 다시 활성화
SET FOREIGN_KEY_CHECKS = 1;

select title, company_id, deadline, is_active from recruit_post
where not exists (select company_id from company where recruit_post.company_id=company.company_id)
order by deadline;

-- 19
create index idx_post_deadline on recruit_post(deadline);
show index from recruit_post;

create index idx_post_jobtype on recruit_post(job_type);
show index from recruit_post;

-- 20
select c.industry, count(*) as '정규직_공고수' from recruit_post r inner join company c on r.company_id=c.company_id
where r.job_type='정규직'
group by job_type, industry;

-- 21
create user 'job_reader'@'localhost' identified by'job1234';
SHOW GRANTS FOR 'job_reader'@'localhost';

-- 22
grant select on job_platform.* to 'job_reader'@'localhost';
SHOW GRANTS FOR 'job_reader'@'localhost';

-- 23
revoke select on job_platform.* from 'job_reader'@'localhost';
SHOW GRANTS FOR 'job_reader'@'localhost';
     
-- 24
drop user 'job_reader'@'localhost';
SHOW GRANTS FOR 'job_reader'@'localhost';

-- 25
create view vw_active_post as select post_id, title, job_type, deadline, is_active from recruit_post
where is_active = 1;

select * from vw_active_post;

drop view vw_active_post;

-- 26
select * from vw_active_post
where job_type ='정규직'
order by deadline ;

-- 27
-- 기존 뷰 삭제
DROP VIEW IF EXISTS vw_active_post;

-- company_id를 포함하여 뷰 재생성
CREATE VIEW vw_active_post AS
SELECT post_id, title, job_type, deadline, is_active, company_id
FROM recruit_post
WHERE is_active = TRUE;

select c.company_name, v.title, v.job_type, v.deadline from vw_active_post v inner join company c on v.company_id=c.company_id
order by deadline;

-- 28
start transaction;

update recruit_post
set title ='실수로 수정된 제목'
where post_id=1;

rollback;

-- 29
start transaction;

update recruit_post
set title ='백엔드 개발자 채용(수정됨)'
where post_id=1;

commit;
rollback;

-- 30
select c.company_name, r.title, r.job_type, r.deadline from recruit_post r inner join company c on r.company_id=c.company_id
where deadline>='2025-06-25' and job_type='정규직' AND is_active=1
order by deadline;

-- 31