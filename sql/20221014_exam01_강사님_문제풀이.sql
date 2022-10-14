-- 2022.10.14 강의 : 문제 풀이

-- 함수 문제 1

--16. SUBSTR 함수를 사용하여 사원들의 입사한 년도와 입사한 달만 출력하시오.
SELECT HIREDATE, SUBSTR(HIREDATE, 1, 5), SUBSTR(HIREDATE, 1, 2), SUBSTR(HIREDATE, 4, 2)FROM EMP;
select hiredate, substr(hiredate, 1, 5), substr(hiredate, 1, 2), substr(hiredate, 4, 2) from emp;

--17. SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력하시오.
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2) = '04';
select * from emp WHERE TO_NUMBER(SUBSTR(HIREDATE, 4, 2), '99') = 4;
select * from emp where substr(hiredate, 4, 2)='04';

--18. MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오.
SELECT * FROM EMP WHERE MOD(EMPNO, 2) = 0;

--19. 입사일을 년도는 2자리(YY), 월은 숫자(MM)로 표시하고 요일은 약어 (DY)로 지정하여 출력하시오.
SELECT ENAME, 
       TO_CHAR(HIREDATE, 'YY') AS "입사 년도", 
       TO_CHAR(HIREDATE, 'MM') AS "입사 월", 
       TO_CHAR(HIREDATE, 'DY') AS "입사 요일",
       TO_CHAR(HIREDATE, 'YY.MM, DY') AS "입사 년도/월/요일"
FROM EMP;
select to_char(hiredate, 'YY-MM-DY') from emp;

--20. 올해 몇 칠이 지났는지 출력하시오. 현재날짜에서 올해 1월 1일을 뺀 결과를 출력하고 TO_DATE 함수를 사용하여 데이터 형을 일치 시키시오.
SELECT TRUNC(SYSDATE - TO_DATE('2022/01/01')) AS "현재 이번 년도의 일수"FROM DUAL;

--21. 사원들의 상관 사번을 출력하되 상관이 없는 사원에 대해서는 NULL 값 대신 0으로 출력하시오.
SELECT NVL(MGR, 0) FROM EMP; -- mgr와 뒤의 값은 타입이 일치 해야 한다!!!

--22. DECODE 함수로 직급에 따라 급여를 인상하도록 하시오. 직급이 ‘ANALIST”인 사원은 200, ‘SALESMAN’인 사원은 180, ‘MANAGER’인 사원은 150, ‘CLERK”인 사원은 100을 인상하시오.
SELECT ENAME, JOB, SAL, DECODE(JOB, 'ANALYST', SAL + 200, 'SALESMAN', SAL + 180, 'MANAGER', SAL + 150, 'CLERK', SAL + 100) AS UP_SAL FROM EMP;

--24. 각 담당 업무 유형별로 급여 최고액, 최저액, 총액 및 평균 액을 출력하시오. 평균에 대해서는 정수로 반올림 하시오.
SELECT JOB, MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL)) FROM EMP GROUP BY JOB;

--25. COUNT(*) 함수를 이용하여 담당업무가 동일한 사원 수를 출력하시오.
SELECT JOB, COUNT(*)FROM EMP GROUP BY JOB; -- (O) null값이 있든 없든 존재한다고 봐야 하면 *
select count(distinct job) from emp; -- (X) job이라고 넣으면 만약에 job이 null이면 카운트에서 제외 되므로 *로 표기하는 것이 좋다.

--26. 관리자(상관) 수를 출력하시오.
SELECT COUNT(DISTINCT MGR)FROM EMP; -- (O)
select count(distinct job) from emp; -- (X)

--27. 급여 최고액, 급여 최저액의 차액을 출력하시오.
SELECT MAX(SAL), MIN(SAL), MAX(SAL) - MIN(SAL)FROM EMP;

--28. 직급별 사원의 최저 급여를 출력하시오. 관리자를 알 수 없는 사원과 최저 급여가 2000 미만인 그룹은 제외시키고 결과를 급여에 대한 내림차순으로 정렬하여 출력하시오.
SELECT MIN(SAL) FROM EMP WHERE MGR IS NOT NULL GROUP BY JOB HAVING NOT MIN(SAL) < 2000 ORDER BY MIN(SAL) DESC;
select job, min(sal) as sal from emp where mgr is not null and sal>=2000 group by job order by sal desc;

--29. 각 부서에 대해 부서번호, 사원 수, 부서 내의 모든 사원의 평균 급여를 출력하시오. 평균 급여는 소수점 둘째 자리로 반올림 하시오.
SELECT DEPTNO, COUNT(*), ROUND(AVG(SAL), 2) AS "부서 평균 급여" FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO;
select deptno, count(*), round(avg(sal),2) from emp group by deptno;

--30. 각 부서에 대해 부서번호 이름, 지역 명, 사원 수, 부서내의 모든 사원의 평균 급여를 출력하시오. 평균 급여는 정수로 반올림 하시오. DECODE 사용.
SELECT DECODE(DEPTNO, 10, 'ACCOUNTING',
                      20, 'RESEARCH',
                      30, 'SALES',
                      40, 'OPERATIONS'
       ) AS DNAME,
       DECODE(DEPTNO, 10, 'NEW YORK',
                      20, 'DALLAS',
                      30, 'CHICAGO',
                      40, 'BOSTON'
       ) AS LOC,
       COUNT(*) AS "사원 수", ROUND(AVG(SAL)) AS "부서 평균 급여"
FROM EMP
GROUP BY DEPTNO
ORDER BY AVG(SAL);

select deptno, decode(deptno,10,'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 40, 'OPERATIONS') as dname, 
decode(deptno,10,'NEW YORK', 20, 'DALLAS', 30, 'CHICAGO', 40, 'BOSTON') as loc, count(deptno) as emp_c, round(avg(sal)) from emp group by deptno;

-- JOIN을 사용한 해결
SELECT DEPT.DNAME, DEPT.LOC, COUNT(*), ROUND(AVG(SAL)) AS "부서 평균 급여"
FROM EMP JOIN DEPT
ON EMP.DEPTNO = DEPT.DEPTNO
GROUP BY DEPT.DEPTNO, DEPT.DNAME, DEPT.LOC
ORDER BY AVG(SAL);

--31. 업무를 표시한 다음 해당 업무에 대해 부서 번호별 급여 및 부서 10, 20, 30의 급여 총액을 각각 출력하시오. 별칭은 각 job, dno, 부서 10, 부서 20, 부서 30, 총액으로 지정하시오. 
--( hint. Decode, group by )
SELECT JOB, DEPTNO,
       DECODE(DEPTNO, 10, SUM(SAL)) AS "부서10",
       DECODE(DEPTNO, 20, SUM(SAL)) AS "부서20",
       DECODE(DEPTNO, 30, SUM(SAL)) AS "부서30",
       SUM(SAL)
FROM EMP
GROUP BY JOB, DEPTNO
ORDER BY DEPTNO;

-- MySQL 코딩
SELECT JOB, DEPTNO, SUM(SAL),
	   -- if(조건, true, false)
       if(DEPTNO=10, SUM(SAL), null) AS "부서10",
       if(DEPTNO=20, SUM(SAL), null) AS "부서20",
       if(DEPTNO=30, SUM(SAL), null) AS "부서30"
FROM EMP
GROUP BY JOB, DEPTNO
ORDER BY DEPTNO;
