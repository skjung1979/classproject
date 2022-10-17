-- 2022.10.17
-- 서브 쿼리

-- SCOTT이 소속된 부서이름 출력
-- Equi Join
select * 
from emp e, dept d
where e.deptno=d.deptno
and e.ename='SCOTT';

select deptno from emp where ename='SCOTT';
select dname from dept where deptno=20;

-- 서브 쿼리를 이용한 부서 찾기
select dname
from dept
where deptno=(select deptno from emp where ename='SCOTT');

-- 1. 스칼라 부속 질의
select custid, (
    select name from customer c where c.custid=o.custid
                            ) as "고객이름"
from orders o
group by custid;

-- 마당서점의 고객별 판매액을 보이시오.
-- (결과는 고객이름과 고객별 판매액을 출력)
select custid, (
                    select name from customer c where c.custid=o.custid
) as name, 
sum(saleprice) as total
from orders o
group by custid;

-- 2. 인라인 뷰: from 절 뒤에 쓰여지는 서브쿼리 => 가상 테이블이다!!
-- 고객번호가 2 이하인 고객의 판매액
select o.custid, c.name, sum(o.saleprice)
from orders o, (
        select custid, name from customer where custid<=2 -- 여기 있는 것은 제외한 컬럼은 보여주지 않기 위해서
)c
where c.custid=o.custid group by o.custid, c.name ;

-- 3. 중첩 질의
-- 평균 급여 보다 더 많은 급여를 받는 사원 검색
select * from emp
where sal > (select avg(sal) from emp);

-- 평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 출력하시오
select orderid, saleprice from orders where saleprice <= ( select avg(saleprice) from orders);

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서
-- 주문번호, 고객번호, 금액을 출력하시오.
select orderid, custid, saleprice
from orders
where saleprice > (select avg(saleprice) from orders);

-- 3000 이상 받는 사원이 소속된 부서와 
-- 동일한 부서에서 근무하는 사원이기에 서브 쿼리의 결과 중에서
-- 하나라도 일치하면 참인 결과를 구하는 IN 연산자와 함께 사용되어야 합니다. 
select * 
from emp
--where deptno=? or deptno=? or ... 이렇게 하지말고 아래처럼
where deptno in (select distinct deptno from emp where sal >= 3000);

-- 서브쿼리 중첩 질의에 들어갈 쿼리문
select distinct deptno from emp where sal >= 3000;

-- ★ IN
-- 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.
select sum(saleprice)
from orders where custid in (select custid from customer where address like '%대한민국%');

select custid from customer where address like '%대한민국%';

-- ★ ANY, SOME
-- 3번 고객이 주문한 도서의 최고  금액보다 더 비싼 도서를 구입한 주문의
-- 주문번호와 금액을 보이시오. 

-- ALL 연산자는 모든 값이 true
-- ALL뒤 서브쿼리의 모든 값!!!
-- 풀이1>
select orderid, saleprice from orders where saleprice > all (select saleprice from orders where custid=3);

select saleprice from orders where custid=3;
-- 풀이 2>
select orderid, saleprice from orders where saleprice > (select max(saleprice) from Orders where custid=3);

--3번 고객의 최고 구매액
select max(saleprice) from Orders where custid=3;

-- EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오. 
select sum(saleprice) 
from orders o
where exists (select * from customer c where c.custid=o.custid and c.address like '%대한민국%');



