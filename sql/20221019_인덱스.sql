-- 2022.10.19
-- 인덱스
-- index: 검색의 성능(속도)을 향상 시킬때 사용한다!!!

-- 인덱스 생성
create index index_emp01_ename on emp01(ename);
-- 인덱스 삭제
drop index index_emp01_ename;

drop table emp01;
select * from emp01;
create table emp01 as select * from emp;
insert into emp01 select * from emp01;
insert into emp01 (empno, ename) values(1111, 'SON');

-- 인덱스 넣어서 조회한 쿼리
select /* index(emp01_index_emp01_enam) */ * from emp01 where ename='SON';
-- 인엑스 없이 조회한 쿼리
select * from emp01 where ename='SON';














