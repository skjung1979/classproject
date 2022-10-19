-- 2022.10.19
-- 가상 테이블 VIEW
-- 데이터를 제한할 수 있고, 복잡한 SQL을 단순하게 처리할 수 있다.

-- 자주 사용되는 30번 부서에 소속되 사원들의 사번과 이름과 부서번호를 출력하기 위한 select문을 하나의 뷰로!
select empno, ename, deptno from emp where deptno=30;

-- view 생성
create view emp_view30 as (select empno, ename, deptno from emp where deptno=30);

select * from emp_view30 where ename='JAMES';

-- user_views테이블은 생성된 뷰에 대한 세부 정보들을 저장하고 있다.
select * from user_views;
select view_name, text from user_views;

drop view emp_view30;