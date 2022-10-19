-- 2022.10.18

-- inline view - rownum / 인라인뷰-로우넘
-- from절 뒤에 오는 서브 쿼리 => inline view이다!
-- select의 결과도 테이블이다!
-- rownum은 오라클에서만 사용한다. MySQl은 limit / MSSQL은 top

select rownum, emp.* from emp order by hiredate;

-- rownum: 사용자가 생성한느 컬럼이 아니다!. 시스템에서 제공하는 컬럼이다! / 테이터 값은 입력된 순서이다!!!!!
-- 인라인뷰로 rownum을 호출하면 새로운 rownum데이터들이 정의된다!!!!
select rownum, t.* from (select * from emp order by hiredate) t;

-- 입사일이 가장 오래된 3명을 구하자!!! / top3
-- rownum으로 정렬을 하고 조건에 rownum을 넣어서 구한다.

select rownum, t.* from (select * from emp order by hiredate) t where rownum<=3;

--★ MySQL에서는 limit를 사용한다.
-- select * from emp order by hiredate limit 0, 3; -- 위에서 3개