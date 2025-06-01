use jdbc_ex;

select * from users;



-- MySQL root 또는 관리자 계정으로 로그인 후 실행
GRANT ALL PRIVILEGES ON jdbc_ex.* TO 'scoula'@'localhost';
FLUSH PRIVILEGES;

select * from users;
