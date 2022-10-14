-- 2022.10.14
-- JOIN : 관계있는 테이블의 스키마를 붙이는 것

-- 1. Cross Join: 집합의 합 표현은 A + B 이렇게 하지만 로직은 A개수*B개수 이다.
select * from emp, dept;
-- 14개 * 4개 => 56개의 결과가 나온다 => 유효하지 않으므로 조건을 부여한다.

-- 2. Equi Join: cross join에 유효하도록 조건을 부여하는 것
select * from emp, dept where emp.deptno=dept.deptno;

select emp.ename, dept.dname from emp, dept where emp.deptno=dept.deptno;

select a.ename, b.dname from emp a, dept b where a.deptno=b.deptno;
select * from emp inner join dept on emp.deptno = dept.deptno;

-- 3. Inner Join
select * from emp inner join dept on emp.deptno = dept.deptno;

select * from emp join dept on emp.deptno = dept.deptno;

-- 4. Self Join: 자기 자신의 테이블과 조인
-- emp => mgr: 상사의 사원번호
-- 각 사원들의 이름과 상사의 이름을 출력
select ename, mgr from emp ;
select a.ename, b.mgr, b.ename from emp a, emp b where a.mgr=b.empno(+); -- 해당 사항이 없어도(null) 표시해야 하면 + 표시를 해준다.!!!(오라클만!!!)

-- 5. Outer Join
select e1.ename, e2.ename from emp e1 left outer join emp e2 on e1.mgr=e2.empno; -- 왼쪽을 다 출력한다!!!!

select e1.ename, e2.ename from emp e1 right outer join emp e2 on e1.empno=e2.mgr; -- 오른쪽을 다 출력한다!!!!

-- Using
select * from emp e inner join dept d using(deptno); -- 조인할때 공통된 컬럼을 중복되지 않게 출력한다.

SELECT EMP.ENAME, DEPT.DNAME 
FROM EMP INNER JOIN DEPT
USING (DEPTNO);

-- Natural Join
select * from emp natural join dept; -- using과 같은 결과

-- 'SCOTT' 사원의 사원번호와 이름, 직급, 부서이름, 바서위치를 출력
-- emp => 사원번호, 이름, 직급
-- dept => 부서이름, 위치
select e.empno, e.ename, e.job, d.dname, d.loc from emp e, dept d where e.deptno=d.deptno and e.ename='SCOTT';

select e.empno, e.ename, e.job, d.dname, d.loc from emp e join dept d on e.deptno=d.deptno where e.ename='SCOTT';

-- salgrade 테이블(급여 등록)을 참조해서 사원들의 사번, 이름, 급여, 급여 등급을 출력 / 키값이 아닌 특정 조건으로 조인도 가능하다!!!!
select ename, losal, sal, hisal, grade from emp e, salgrade s where e.sal between s.losal and s.hisal;

select ename, losal, sal, hisal, grade from emp e join salgrade s on  e.sal between s.losal and s.hisal;

-- 판매내역: 판매정보, 판매서적의 정보, 고객의 정보
select * from book;
select * from customer;
select * from orders;

select * from book, customer, orders where orders.custid=customer.custid and orders.bookid=book.bookid; -- orders를 기준으로 출력되는 것임!!!
select orders.orderdate, customer.name, book.bookname, book.price, orders.saleprice from book, customer, orders
where orders.custid=customer.custid and orders.bookid=book.bookid
order by orders.orderdate desc;



