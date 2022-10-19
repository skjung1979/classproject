-- 2022.10.18
-- Join & SubQuery 강사님 문제풀이

-- 1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
-- (5) 박지성이구매한도서의출판사수
select count(distinct publisher) 
from book a, orders b, customer c 
where a.bookid=b.bookid and b.custid=c.custid and c.name='박지성'; -- SK

    -- 전체 출판사 개수
select count(distinct publisher) from book;
    -- 박지성이 구매한 출판사수
select count(distinct b.publisher) from orders o, book b, customer c where o.bookid=b.bookid and o.custid=c.custid and c.name='박지성'; -- 강사님

select * from orders o, book b where o.bookid=b.bookid and o.custid=(select custid from customer where name='박지성'); -- 강사님

-- (6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select b.bookname, b.price, abs(o.saleprice-b.price) as pricegap 
from orders o, book b, customer c 
where o.bookid=b.bookid and o.custid=c.custid and c.name='박지성'; -- SK

select name, bookname, price, saleprice, price-saleprice as gapprice from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid and c.name='박지성'; -- 강사님

-- (7) 박지성이구매하지않은도서의이름
select bookname 
from book 
where bookid not in (
select bookid from orders o left outer join customer c on o.custid=c.custid
where c.name='박지성'); -- SK

select bookname from book
where bookid not in (select distinct bookid from orders o, customer c where o.custid=c.custid and c.name='박지성');
select distinct bookid from orders o, customer c where o.custid=c.custid and c.name='박지성'; -- 강사님

-- 2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
-- ★★★(8) 주문하지않은고객의이름(부속질의사용)
select name from customer where custid not in (select distinct custid from orders); -- SK == 강사님

select * from customer c where not exists (select * from orders o where c.custid=o.custid); -- 강사님
select * from customer c, orders o where c.custid=o.custid(+) and o.orderid is null; -- 강사님
select * from customer c left outer join orders o on c.custid=o.custid where o.orderid is null; -- 강사님

-- (9) 주문금액의총액과주문의평균금액
select sum(saleprice) total, avg(saleprice) avg_saleprice from orders; -- SK

select sum(saleprice), avg(saleprice) from orders; -- 강사님

-- (10) 고객의이름과고객별구매액
select c.name, sum(o.saleprice) from customer c right join orders o on c.custid=o.custid group by c.name; -- SK

select c.custid, c.name, sum(o.saleprice) from orders o, customer c 
where o.custid=c.custid group by c.custid, c.name order by c.custid; -- 강사님

-- (11) 고객의이름과고객이구매한도서목록
select c.name, b.bookname from customer c, orders o, book b where c.custid=o.custid and o.bookid=b.bookid order by c.name, b.bookname; -- SK

select name, bookname from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid; -- 강사님

-- ★★★(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
select * from orders o, book b 
where o.bookid=b.bookid 
and abs(b.price-o.saleprice)=(select max(abs(b.price-o.saleprice)) 
from book b, orders o where b.bookid=o.bookid); -- SK

    -- 서브쿼리
select max(price-saleprice) from orders o, book b where o.bookid=b.bookid;

    -- 몸체
select orderid, price, saleprice, price-saleprice from orders o, book b 
where o.bookid=b.bookid and price-saleprice = (서브쿼리);

    -- 합체
select orderid, price, saleprice, price-saleprice from orders o, book b 
where o.bookid=b.bookid and price-saleprice = (select max(price-saleprice) 
from orders o, book b where o.bookid=b.bookid); -- 강사님

-- ★★★(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름
select c.name from customer c, (
select custid, avg(saleprice) as avg_saleprice from orders group by custid
) d 
where c.custid=d.custid 
and d.avg_saleprice>(select avg(saleprice) from orders); -- SK

    -- 몸체(구매 평균)
select c.custid, c.name, avg(saleprice) from customer c, orders o 
where o.custid=c.custid group by c.custid, c.name 
having avg(saleprice) > (전체도서구 판매평균)
order by c.custid;

    -- 전체 도서의 판매평균
select avg(saleprice) from orders;

    -- 합체
select c.custid, c.name, avg(saleprice) from customer c, orders o 
where o.custid=c.custid group by c.custid, c.name 
having avg(saleprice) > (select avg(saleprice) from orders)
order by c.custid; -- 강사님

-- 3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
-- (1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select distinct c.name from book b, orders o, customer c 
where b.bookid=o.bookid and o.custid=c.custid
 and b.publisher in (select b.publisher from book b, orders o, customer c where b.bookid=o.bookid and o.custid=c.custid and c.name='박지성')
 and c.name <> '박지성'; -- SK
 
    -- 박지성이 구매한 도서의 출판사
select publisher from orders o, customer c, book b 
where o.custid=c.custid and o.bookid=b.bookid and name='박지성';
    
    -- 구매내역 있는 고객중 출판사가 
select * from orders o, customer c, book b where o.custid=c.custid and o.bookid=b.bookid
and b.publisher in (박지성이 구매한 도서의 출판사);

    -- 합체
select name from orders o, customer c, book b where o.custid=c.custid and o.bookid=b.bookid
and b.publisher in (select publisher from orders o, customer c, book b 
where o.custid=c.custid and o.bookid=b.bookid and name='박지성') and name<>'박지성';  -- 강사님

-- ★★★(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select c.name from customer c, (
select o.custid, count(distinct b.publisher) as cnt 
from orders o left join book b on o.bookid=b.bookid group by o.custid having (count(distinct b.publisher))>=2 order by o.custid
) d where c.custid=d.custid; -- SK

select o.custid, name, count(distinct publisher) from orders o, customer c, book b where o.custid=c.custid and o.bookid=b.bookid
group by o.custid, name
having count(distinct publisher) > 1; -- 강사님

