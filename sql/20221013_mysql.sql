-- ★ 문자함수
select upper('scott') from dual; -- 대문자로 변환
select lower('SCOTT') from dual; -- 소문자로 변환
select concat('Steven', ' is ', 'King') from dual;

select replace('Steven King', 'Steven', 'S.') from dual; -- 특정문자 대체

select format('123456789', '000,000,000,000') from dual; -- 원본 숫자를 자리수 맞게 컴마 출력

select lpad(40, 5, '000'), rpad(40, 5, '000') from dual; -- 공백은 패턴으로 출력

select substr('안녕하세요. 손흥민입니다.', 2) from dual; -- 2번째부터 뒤로 쭉~
select substr('안녕하세요. 손흥민입니다.', 2, 8) from dual; -- 2번째부터 8개 출력
select substring('안녕하세요. 손흥민입니다.', 2) from dual;
select substring('안녕하세요. 손흥민입니다.', 2,8) from dual;

select '     ABC', trim('     ABC'), 'ABC          ', trim('ABC          '), '          ABC          ', trim('          ABC          ')
from dual; -- 앞뒤 공백 제거

select now() from dual;

-- ★ 숫자 함수
select -10, abs(-10) from dual;

select 2.1, 2.9, floor(2.9)  from dual; -- 소수점 이하 버림

select 1234.567, round(1234.527, 1), round(1235.527, -1), round(1235.527) from dual; -- 반올림

-- 오라클 => trunc과 동일
select 1234.567, truncate(1234.567, 0), truncate(1234.567, 1), truncate(1234.567, -1) from dual;

-- mysql에서 0나누기 결과 값은 null!!
select mod(1,3), mod(2,3), mod(3,3), mod(0,3), mod(3,0) from dual; -- 0으로 나누면 null이 나옴 mod(3,0)의 결과

-- ★ 날짜 시간 함수
-- 현재 시간
select CURDATE(), CURTIME(), NOW(), SYSDATE(), current_timestamp() from dual;
select year(now()), month(now()), day(now()), hour(now()), minute(now()), second(now()) from dual;
select date(now()), time(now()) from dual;
select ADDDATE(now(), 10), SUBDATE(now(), 10)  from dual; -- 현재 날짜에서 10일 추가 / 10일 빼기
select now(), ADDTIME(now(), 10), SUBTIME(now(), 10)  from dual; -- 현재 시간에서 10초 추가 / 10초 빼기
select DATEDIFF(now(), '2022-01-01'), TIMEDIFF(CURTIME(), '00:00:00')  from dual;
select last_day(now()) from dual;

-- ★ 변환
-- to_char / to_date
-- %Y => YYYY
-- %y => YY
-- %m => MM
-- %d => DD
select str_to_date('20220517', '%Y%m%d') from dual;
select date_format(now(), '%Y.%m.%d %H:%i:%s') from dual;

select now() from dual; -- aws서버의 시간???