-- 2022.10.19
-- 트랜잭션 commit, rollback

-- Transaction: 일의 단위 => 여러 DML들을 묶어둔 것!
-- commit: 작업의 완료 => 데이터의 물리적 저장
-- rollback: 작업 실패 => 마지막(최근) 물리적 저장 상태(commit시점)로 복귀

drop table dept02;
create table dept02 as select * from dept;

-- DDL 작업 후에는 자동으로 commit이 된다!!! == 되돌릴수 없다!!!

select * from dept02;
desc dept02;

-- 트랜잭션 시작
insert into dept02 values (50, '개발', '서울');
insert into dept02 values (60, '기획', '판교');
update dept02 set loc='제주' where deptno=60;

rollback;
commit;