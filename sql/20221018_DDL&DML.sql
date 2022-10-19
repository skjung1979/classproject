-- 2022.10.18

-- DDL : 정의어 => 객체를 정의하는 명령어
-- 데이터의 저장 공간 생성
-- creat table 테이블명 (
--            컬럼명   타입  [제약조건], 
--            컬럼명   타입  [제약조건], 
--             .....  
--   );

-- 테이블 생성과 제약조건
create table emp01(
    empno number(4) constraint emp01_empno_pk primary key, 
    ename varchar2(10) constraint emp01_ename_NN not null,
    job varchar2(9) constraint emp01_job_UK unique,
    sal number(7,2) constraint emp01_sal_CK check (sal between 500 and 5000), 
    gender char(1) constraint emp01_gender_CK check (gender in ('M','F')),
    deptno number(2) constraint emp01_deptno_FK references dept(deptno),
    hiredate date default sysdate       
);

-- 제약 조건을 행이 아닌 생성구문 하단에 넣는 경우

drop table emp02;
create table emp02(
    empno number(4), 
    ename varchar2(10) constraint emp02_ename_NN not null,
    job varchar2(9),
    sal number(7,2), 
    gender char(1),
    deptno number(2),
    hiredate date default sysdate,
    constraint emp02_empno_pk primary key (empno),
    constraint emp02_job_uk unique (job),
    constraint emp02_sal_ck check (sal between 500 and 5000),
    constraint emp02_gender_ck check (gender in ('M', 'F')),
    constraint emp02_deptno_fk foreign key (deptno) references dept(deptno)
);



★★★★★★★★★★★ DML ★★★★★★★★★★★


-- insert 양식
    -- 1. 필요한 컬럼만 데이터 넣는 경우
insert into emp01 (원본컬럼명1, 원본컬럼명2 원본컬럼명3, 원본컬럼명4) values('자료1', '자료2', '자료3', '자료4'); 
    -- 2. 전체 컬럼에 데이터를 넣는 경우
insert into emp01 values(1113, '김소연', 'CAP', 3000, 'F', 40);
    -- 3. 특정테이블 조회해서 바로 테이블 생성
insert into emp01 select * from emp01;

-- 데이터의 수정
-- update 테이블명 set 컬럼명1=새로운값, 컬럼명2=새로운값 where 행 선택 조건;

drop table emp03;
create table emp03 as select * from emp; -- emp와 동일하게(데이터 포함) emp03 테이블 생성!!!

-- 모든 사원의 부서 번호를 30으로 변경
update emp03 set deptno=30;

select * from emp03;

-- 모든 사원의 급여를 10% 인상하자
update emp03 set sal=sal*1.1;

-- 모든 사원의 입사일을 오늘 날짜로 변경
update emp03 set hiredate=sysdate;

-- 부서번호가 10번인 사원의 부서번호를 30번으로 변경
update emp03 set deptno=30 where deptno=10;

-- 급여가 3000이상인 사원의 급여를 10% 인상
update emp03 set sal=sal*1.1 where sal>=3000;

-- SCOTT 사원을 20번 부서로 이동, 직급을 manager로 변경
update emp03 set deptno=20, job='MANAGER' where ename='SCOTT';

-- SMITH사원을 BLAKE사원의 부서로 이동
update emp03 set deptno=(select deptno from emp03 where ename='BLAKE') where ename='SMITH';

drop table dept01;
select * from dept01;
create table dept01 as select * from dept;

-- 부서 번호가 20번인 부서의 이름과 지역은 RESEARCH와 DALLAS입니다. 다음은 부서번호가 20인 
-- 부서의 부서명과 지역명을 부서 번호가 40번인 부서와 동일하게 변경하기 위한 UPDATE 명령문입니다
update dept01 set (dname, loc) = (select dname, loc from dept where deptno=40)
where deptno=20;

-- 테이블의 행을 삭제
-- delete from 테이블명 where 삭제조건

-- delete문으로 부서 테이블의 모든 행을 삭제
delete from dept01;

select * from emp03;

-- 대표 사퇴
delete from emp03 where empno=7839;

-- 40번 부서 모든 사원 퇴사
delete from emp03 where deptno=40;

-- 부서이름이 SALES인 사원이 모두 퇴사
delete from emp03 where deptno = (select deptno from dept where dname='SALES');

