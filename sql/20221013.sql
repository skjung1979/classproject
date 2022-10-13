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











