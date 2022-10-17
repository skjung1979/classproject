-- 2022.10.17
-- DDL : 정의어 => 객체를 정의하는 명령어
-- 데이터의 저장 공간 생성
-- creat table 테이블명 (
--            컬럼명   타입  [제약조건], 
--            컬럼명   타입  [제약조건], 
--             .....  
--   );

------------- CREATE -------------
create table ddl_test(
    no number(3) not null unique,
    name varchar2(10),
    birth date default sysdate
);

desc emp;
--  사원 테이블과 유사한 구조의 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 EMP01 테이블을 생성해 봅시다. 
create table emp01(
    empno number(4),
    ename varchar2(10),
    sal number(7,2)
    );
    
insert into emp01 (empno, ename, sal) values (1111, 'Son', 100);
    
select * from emp01;

-- ★ as : 서브쿼리를 이용해서 기존 테이블 구조로 테이블 생성 및 데이터 저장 한다. / 제약 조건은 카피되지 않는다.
create table emp02
as
select * from emp;

desc emp02; -- 제약 조건은 카피되지 않았다.

-- 원하는 컬럼만 카피해서 테이블 생성
create table emp03
as
select empno, ename, job, hiredate from emp;

desc emp03;

select empno, ename, job from emp where deptno=20;

create table emp04
as
select empno, ename, job from emp where deptno=20;

desc emp04;
select * from emp04;

-- 스키마(컬럼만)만 복사하여 테이블 생성하기. 데이터는 안 가져옴
create table emp05
as
select * from emp where 1=0;

desc emp05;
select * from emp05;

------------- ALTER -------------
--테이블의 컬럼 수정
-- alter table 테이블이름 add => 컬럼 추가

desc emp01;
-- job 컬럼 추가하기
alter table emp01 add (job varchar2(9));
select * from emp01;

-- alter table 테이블이름 modify => 컬럼 수정
alter table emp01 modify (job varchar2(30) default 'manager');
alter table emp01 modify (job default 'dev');
-- 오류 발생 왜냐면 이미 null값이 들어가 있으므로
alter table emp01 modify (job not null); 

-- 컬럼명 변경: 형식>   ALTER TABLE 테이블명 RENAME COLUMN old컬럼명 TO new컬럼명;
alter table emp01 rename column job to job2;

-- alter table 테이블이름 drop => 컬럼 삭제
alter table emp01 drop column job;

------------- DROP -------------
-- 테이블 객체 삭제 / 롤백 안되니 주의!!!
--drop table 테이블명
drop table emp02;
desc emp02;
select * from emp02;

-- 테이블의 모든 행을 삭제. 스키마(컬럼)만 남기고 모든 데이터 삭제 / 롤백 안되니 주의!!!
-- truncate table 테이블명
select * from emp03;
truncate table emp03;

-- 테이블의 이름 변경:  형식>   rename 기존 테이블 이름 to 새로운 이름
select * from emp03;
rename emp03 to test03;
select * from test03;

------------- 무결성을 위한 제약 조건 -------------
-- 1. NOT NULL
create table emp01(
    empno number(4),
    ename varchar2(10),
    job varchar2(9),
    deptno number(2)
);

--제약 조건을 바로 주지 않으면 원하는 컬럼에 공란으로 값을 넣을 수 있다.  -> 쓸모 없는 데이터
-- not null을 설정하면 null있는 것으로 인서트하면 에러가 나서 데이터를 넣을 수없다.
insert into emp01 (job, deptno) values('Manaber', 20);
select * from emp01;

drop table emp01;

-- NOT NULL 제약 조건 설정하여 테이블 생성
create table emp01(
    empno number(4) not null, -- not null 제약 조건은 반드시 컬럼 정의 위치에서 정의해야 한다.
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
);

-- 하지만 null은 혀용하지 않지만, 데이터들이 중복으로 계속 들어 갈수 있다. -> 유니크 설정을 해줘야 한다.
insert into emp01 (empno, ename, job, deptno) values(1111, 'King', 'Managerr', 60);
select * from emp01;

-- 2. UNIQUE 제약 조건 설정: 중복 데이터 방지
-- not null에 추가로 unique 제약조건까지 걸어서, 해당 컬럼은 not null,이고 중복 입력도 안된다.
drop table emp01;
create table emp01(
    empno number(4) not null unique,
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
);

desc emp01;

-- 3. PRIMARY KEY
-- 기본키 제약 조건 정의
create table emp01(
    empno number(4) primary key, -- 여기!!!
    ename varchar2(10) not null,
    job varchar2(9),
    deptno number(2)
);

-- 기본키 제약 조건 정의: 제약조건의 이름 등록!!!
create table emp01(
    empno number(4) constraint emp01_empno_pk primary key, -- 여기!!! 이름을 등록 한다!!
    ename varchar2(10) constraint emp01_ename_NN not null,
    job varchar2(9) constraint emp01_job_UK unique,
    deptno number(2)
);

-- 4.FOREIGN KEY
-- 외래키 제약 조건 정의
create table emp01(
    empno number(4) constraint emp01_empno_pk primary key, 
    ename varchar2(10) constraint emp01_ename_NN not null,
    job varchar2(9) constraint emp01_job_UK unique,
    deptno number(2) constraint emp01_deptno_FK references dept(deptno) -- 여기!!!   형식>    reference 외래테이블명(컬럼명)
);

-- 5. CHECK 조건
-- check 제약
create table emp01(
    empno number(4) constraint emp01_empno_pk primary key, 
    ename varchar2(10) constraint emp01_ename_NN not null,
    job varchar2(9) constraint emp01_job_UK unique,
    sal number(7,2) constraint emp01_sal_CK check (sal between 500 and 5000), -- 여기!!! 조건 500~5000만 입력 받도록! 형식> check (조건식)
    gender char(1) constraint emp01_gender_CK check (gender in ('M','F')), -- 여기!!!  남자는 M, 여자는 F만 입력 받도록!
    deptno number(2) constraint emp01_deptno_FK references dept(deptno)
);
drop table emp01;
desc emp01;
select * from emp01;

-- sal과 gender에 check조거에 위배되는 값을 넣어본다.
insert into emp01 values(1111, '손흥민', 'MANAGER', 5000, 'M', 20);
insert into emp01 values(1112, '황희찬', 'PLAYER', 4000, 'M', 30);
insert into emp01 values(1113, '김소연', 'CAP', 3000, 'F', 40);

-- 6. DEFAULT
-- (암묵적인) null 값의 입력시 기본으로 저장할 값을 정의
create table emp01(
    empno number(4) constraint emp01_empno_pk primary key, 
    ename varchar2(10) constraint emp01_ename_NN not null,
    job varchar2(9) constraint emp01_job_UK unique,
    sal number(7,2) constraint emp01_sal_CK check (sal between 500 and 5000), 
    gender char(1) constraint emp01_gender_CK check (gender in ('M','F')),
    deptno number(2) constraint emp01_deptno_FK references dept(deptno),
    hiredate date default sysdate       
);

insert into emp01 (empno, ename, sal, gender, job, deptno) values(1111, '손흥민', 4000, 'M', 'Player', 20);

-- default가 없는 컬럼의 null 입력
create table emp01(
    empno number(4) constraint emp01_empno_pk primary key, 
    ename varchar2(10) constraint emp01_ename_NN not null,
    job varchar2(9) constraint emp01_job_UK unique,
    sal number(7,2) constraint emp01_sal_CK check (sal between 500 and 5000), 
    gender char(1) constraint emp01_gender_CK check (gender in ('M','F')),
    deptno number(2) constraint emp01_deptno_FK references dept(deptno),
    hiredate date 
);

insert into emp01 (empno, ename, sal, gender, job, deptno) values(1111, '손흥민', 4000, 'M', 'Player', 20);
-- 날짜 컬럼에 default 설정을 하지 않았다면 데이터를 insert할때 넣어도 된다. 

insert into emp01 (empno, ename, sal, gender, job, deptno, hiredate) values(1111, '손흥민', 4000, 'M', 'Player', 20, sysdate);





