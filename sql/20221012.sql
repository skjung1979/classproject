-- 2022.10.12

-- 사용 가능한 테이블 정보
select * from tab;

-- 테이블 구조 확인
desc dept;

select ename -- *
from emp;

-- 원하는 순서에 맞게 컬럼을 배치하면 된다.
select deptno, job, sal, ename
from emp;

-- select [distinct] 컬럼이름, 컬럼이름, ...
-- from 테이블의 이름

select * from dept; -- 행을 선택하는 조건이 없기 때문에 모든 행이 결과로 출력된다.

select deptno, dname from dept;

select sal, nvl(comm, 0) from emp;

-- select의 표현 영역에서는 산술연산이 가능
-- null: 정해지지 않은 값이다. 그러므로 결과도 null이 된다.
select sal + comm as sum
from emp;

select sal, sal - 100
from emp;

select sal * 12
from emp;

select sal / 5
from emp;

-- 사원 테이블에서 사원 이름과  월급여, 연봉을 출력하자.
select ename as "사원명", sal as "월급여", sal*12 as "연봉"
from emp;

select ename as "사원명", sal as "월급여", sal*12 as "연봉", sal*12+comm
from emp;

-- null의 값을 치환해주는 함수: nvl(원본데이터(컬럼), null 일대 치환되는 값) - 오라클
-- mysql에서는 ifnull(원본컬럼, 대치값)함수 - mysql
select ename, sal, sal*12 yearSal1, sal*12+nvl(comm, 0) yearSal2
from emp;

-- 문자열 연산 => ||
select ename || ' is a ' || job
from emp;

-- distinct: 중복된 데이터를 생략하고 출력 해주는 키워드
select deptno
from emp;

select distinct deptno
from emp;

-- 행을 찾는 조건
-- select
-- from
-- where 조건식 <== 행을 찾는 조건식
-- 급여를 3000이상 받는 사원의 이름과 직급 출력 리스트를 찾아라
select ename, job
from emp where sal >= 3000;

-- 부서 테이블에서 부서 번호가 10번인 사원의 리스트를 출력하자
select * from emp where deptno=10;

-- 10번 부서 소속이 아닌 사원들의 리스트 출력
select * from emp where deptno!=10;
select * from emp where deptno<>10;

-- 이름으로 검색 => 문자열은 작은 따옴표로 표시 ex) 'SCOTT'
-- ename='SCOTT'
-- 저장된 문자열은 대소문자를 구별해야 하기 때문에 주의!!!! => DB에서 함수처리에 의해 검색한다?
-- 이름이 SCOTT인 사원의 정보를 출력하자.
select * from emp where ename='SCOTT';

select * from emp where hiredate='81/11/17'; -- 날짜 비교시에도 작은 따옴표로 사용해서 비교

-- 논리 연산 => 비교 연산을 여러개 사용해서 결과를 만든다.
-- and, or, not 

-- 10번 부서의 매니저를 검색하자!
select * from emp;
select * from emp where deptno=10 and job='MANAGER';

-- 10번 부서에 소속한 사원들과 매니저들을 출력하자.
select * from emp where deptno=10 or job='MANAGER';

-- 10번 부서 소속이 아닌 사원들의 리스트 출력
select * from emp where not deptno=10; -- <>, !=와 동일한 결과

-- 10번 부서 소속인 사원들 중에서
-- 직급이 MANAGER인 사람을 검색하여 사원명, 부서번호, 직급을 출력
select ename, deptno, job from emp where deptno=10 and job='MANAGER';

-- 10번 부서에 소속된 사원이거나 직급이 MANAGER인 사람을 검색하여 사원명, 부서번호, 직급을 출력합시다.
select ename, deptno, job from emp where deptno=10 or job='MANAGER';

-- 2000이상에서 3000이하 사이의 급여를 받는 사원의 리스트
select * from emp where sal>=2000 and sal<=3000;

select * from emp where sal between 2000 and 3000; -- ~이상~이하의 결과를 나타낸다. 해당 범위를 포함하는 값들이다!!!

-- 1987년에 입사한 사원 리스트 출력
select * from emp where hiredate between '87/01/01' and '87/12/31';

-- IN(a,b,c) 다수 검색
-- 커미션이 300 이거나 500 이거나 1400 인 사원을 검색하기 위해서 IN 연산자를 사용해 봅시다.
-- in(a,b,c) in 안에 서브 쿼리를 넣어 조회하는 경우가 많다.
select * from emp where comm=300 or comm=500 or comm=1400 or comm=0;
select * from emp where comm in (300, 500, 1400, 0);

-- LIKE 패턴 검색: 문자나 문자열 패턴 검색
-- 이름 검색: ename = 'SC'
-- 이름이 "F"로 시작하는 이름을 검색
select * from emp where ename like 'F%';    -- %뒤에는 뭐가 오든 몇개가 오든  상관없다는 의미!!
-- 이름에 'F'가 포함된 이름을 검색
select * from emp where ename like '%F%';

-- %는 앞뒤로 몇개가 오든 상관 없는 것이지만,,, 언더바(_)는 자릿수를 나타낸다.  뭐가 오든 상관없지만,, n개는 와야한다는 것!!! 언더바를 찍은 개수만큼!!!
select * from emp where ename like '____N%';

-- null 여부를 확인할 때는 "is null" or "is not null"로 조건 넣어라!
-- null은 비교 연산자를 사용할 수 없다.!!! ex) comm=null (X)
select * from emp where comm=null; -- (X)
select * from emp where comm is null; -- (O)

-- 커미션을 받지 않는 사원
select * from emp where comm is null or comm=0;

-- 커미션이 등록된 사원의 리스트
select * from emp where comm is not null and comm<>0;

-- 결과 행의 정렬: order by 컬럼명 asc (or desc) asc는 생략해도되며, 기본값은 오름차순이다.
select * from emp order by sal asc;
select * from emp order by sal desc;

-- 사원 리스트를 이름 순으로 출력
select * from emp order by ename;

-- 입사일 이 가장 빠른 사원의 리스트를 출력
select * from emp order by hiredate;
-- 가장 최근 입사자부터 정렬하는 리스트 출력
select * from emp order by hiredate desc, job asc;

select * from emp order by sal, ename desc;


