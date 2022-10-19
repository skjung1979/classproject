-- 2022.10.19
-- 시퀀스 : 자동 순번 생성기

create SEQUENCE seq_Dept_deptno
START WITH 10
INCREMENT BY 10;

-- 새로운 값을 생성: 시퀀스의 nextval  속성 이용! -> 다음 값을 생성해서 반환
select seq_Dept_deptno.NEXTVAL from dual;
select seq_Dept_deptno.CURRVAL from dual;

-- 시퀀스 삭제
drop SEQUENCE seq_Dept_deptno;

drop table dept04;
create table dept04 as select * from dept where 1=0;
select * from dept04;
delete from dept04;

insert into dept04 values (seq_Dept_deptno.nextval, '개발','서울');