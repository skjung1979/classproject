-- 2022.10.13

-- 함수: 단일행 함수, 집합 함수

select ename, sal, nvl(comm, 0) as comm from emp where nvl(comm, 0)>=0;

-- ★ 문자 함수
-- 1. 모두 소문자로 표시
select lower('SCOTT') from dual;
select ename, lower(ename) from emp;

-- 2. 모두 대문자로 표시
select upper('scott') from dual;

-- 3. 첫 문자만 대문자로 표시
select initcap('scott') from dual;

-- 4. 특정 문자열 잘라서 반환 / 형식: substr(원본, 시작포인트, 반환 개수)
select substr('안녕하세요. 손흥민입니다.', 2, 3) from dual;
select substr('안녕하세요. 손흥민입니다.', 5) from dual; -- 반환 개수를 생략하면 시작 포인트부터 뒤로 모두 반환

-- 5. 문자열 개수 반환
select length('안녕하세요. 손흥민입니다.') from dual;

-- 6. lpad, rpad 특정 자리수를 지정하고 자리수에 데이터가 없는 경우 특정 패턴으로 채우는 함수 / 형식: lpad(원본, 전체자리수, 왼쪽 나머지 대체값)
select dname, deptno, lpad(deptno, 5, '0'), rpad(deptno, 5, 'A') from dept;

-- 7. 앞뒤 공백을 제거하고 반환
select '     ABC   ', trim('     ABC   '), 'ABC        ', trim('ABC        ') from dual;

-- 8. 특정 문자를 치환(대체)하는 함수 / 형식: replace(원본, 대상문자, 치환값)
select 'Steven King', replace('Steven King', 'Steven', 'S.') from dual;

-- ★ 숫자 함수
-- 1. 절대값으로 반환
select -100, abs(-100) from dual;

-- 2. 소수점 이하를 버려 정수로 반환. 반올림 아님!!!
select 2.1, floor(2.1) from dual;

-- 3. 반올림 / 형식: round(원본, 소수점 자리수)
select 15154.578, round(15154.578, 1), round(15154.578, -1), round(15154.578) from dual;

-- 4. 지정한 자리수로 잘라냄. 절사할 경우 사용할 수도 있음!!! / 형식: trunc(원본, 소수점 자리수)
select 1234.567, trunc(1234.567, 1), trunc(1234.567, -1), trunc(1234.567) from dual;

-- 5. 입력 받은 수를 나눈 나머지 값을 반환
select mod(1,3), mod(2,3), mod(3,3), mod(0,3), mod(3,0) from dual;

-- ★ 날짜 함수
-- 1. 현재 날짜
select sysdate from dual;

-- 2. 두 날짜 사이가 몇 개월인지를 반환 / 형식: months_between(날짜1, 날짜2)
select months_between(sysdate, '21/12/13') from dual;

-- 3. 특정 날짜에 개월 수를 더함 / 형식: add_months(날짜, +-개월수)
select add_months(sysdate, 2), add_months(sysdate, -2) from dual;

-- 4. 특정 날짜에서 최초로 도래하는 인자로 받은 요일의 날짜를 반환 / 형식: next_day(기준날짜, 요일넘버) / 요일 넘버: 0:일요일 1:월요일~
select next_day(sysdate, 1) from dual;

-- 5. 해당 달의 마지막 날짜를 반환
select last_day(sysdate) from dual;

-- 6. 인자로 받은 날짜를 특정 기준으로 반올림. 오후 12시가 지나면 반올림한다!!
select round(sysdate) from dual;

-- 7. 인자로 받은 날짜를 특정 기준으로 버림. 오후12시 기준으로 절사!!
select trunc(sysdate) from dual;

-- ★ 변환 함수
-- 1. to_char(원본, '포맷')
-- a. date => string pattern
select sysdate, to_char(sysdate, 'YYYY-MM-DD'), to_char(sysdate, 'YYYY.MM.DD'),
to_char(sysdate, 'YYYY.MM.DD PM HH12:MI:SS'), to_char(sysdate, 'YYYY.MM.DD HH24:MI:SS')
from dual;

-- b. number => varchar2
select to_char(123456789, '000000000000'), to_char(123456789, '999,999,999,999'), to_char(123456789, 'L999,999,999,999')
from dual; 

select ename, sal, to_char(sal*1350, 'L999,999,999,999,999')  from emp;

-- 2. varchar2 => date
-- to_date(문자열, '날짜형식')
select to_date('19991213', 'YYYYMMDD'), to_date('1999-12-13', 'YYYY-MM-DD')
from dual;

-- 3. varchar2 => numbers
select '20,000', to_number('20,000', '999,999,999')+5, to_number('20,000', '999,999,999')+to_number('10,000', '999,999,999')
from dual;

-- decod 함수 => 여러가지 비교를 통해 결과 출력 switch - case와 유사한 개념
select ename, deptno, decode(deptno, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATION') as dname from emp;

-- 예제) 직급에 따라 급여를 인상하도록 하자.
--직급이 'ANALYST'인 사원은 5%, 'SALESMAN'인 사원은 10%,'MANAGER'인 사원은 15%, 'CLERK'인 사원은 20%인 인상한다.
select ename, job, sal
, nvl(decode(job, 'ANALYST', sal*1.05, 'SALESMAN', sal*1.1, 'MANAGER', sal*1.15, 'CLERK', sal*1.2), 0) as up_sal
from emp;

-- case when then
select ename, deptno
, case when deptno=10 then 'ACCOUNTING' when deptno=20 then 'RESEARCH' when deptno=30 then 'SALES' when deptno =40 then 'OPERATION' end as dname
from emp;

-------------------------------------------------------------
-- 그룹 함수 = 집합함수 = 집계함수 = 다중행 함수
-- sum, avg, count, max, min

-- 회사의 모든 사원의 급여 총액: 월 지출액
select sum(sal) from emp;

-- 커미션 총액
select sum(comm), count(comm), avg(comm) from emp; -- comm에서 null은 제외하고 카운팅 됨

-- 급여 평균
select trunc(avg(sal), -1) from emp;
select round(avg(sal)) from emp;

-- 최고 급여 찾기
select max(sal) from emp;

-- 최저 급여 찾기
select min(sal) from emp;

-- 최저 급여를 받는 사원
select * from emp where sal=(select min(sal) from emp);

-- 전체 사원의 수
select count(*) from emp;

-- 보유한 책의 개수, 고객의 수, 판매 횟수
select count(*) from book;
select count(*) from customer;
select count(*) from orders;

-- 직급의 수
select count(distinct job) from emp;

-- 도서 DB에서 등록된 출판사의 수
select count(distinct publisher) from book;

-- group by => 특정 컬럼 값을 기준으로 그룹핑. 특정 컬럽을 기준으로 집합 함수로 통계를 출력할수 있다.
select * from emp;
select deptno, count(*), sum(sal), trunc(avg(sal)), max(sal), min(sal), count(comm)
from emp group by deptno;

-- having => group by 의 결과 값을 가지고 조건 걸어서 조회하는 것
-- 부서별 평균 급여가 2000 이상인 부서의 데이터만 출력
select deptno, count(*), sum(sal), trunc(avg(sal)), max(sal), min(sal), count(comm)
from emp group by deptno
having  avg(sal) >= 2000;

-- 부서의 최대값과 최소값을 구하되 최대 급여가 2900이상인 부서만 출력합니다. 
select deptno, max(sal), min(sal) from emp group by deptno having max(sal)>=2900;
select deptno, count(*), sum(sal), trunc(avg(sal)), max(sal), min(sal), count(comm)
from emp group by deptno
having  max(sal) >= 2900;

-- 직급 기준으로 그룹핑
select * from emp;
select job, count(*), max(sal), min(sal)
from emp group by job;



