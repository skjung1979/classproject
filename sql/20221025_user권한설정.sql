select * from member;
desc member;

-- "ORA-01950: 테이블스페이스 'USERS'에 대한 권한이 없습니다." 이런 에러가 날 경우 아래 쿼리 실행
--ALTER USER [유저명] DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

--* 만약 아래와 같은 에러가 뜬다면 참고바란다.
--ORA-01031: 권한이 불충분합니다
--에러가 발생할 경우, 권한이 빠져있어서이다.

--해결법 : 
-- sqlplus sys as sysdba
-- GRANT CREATE ANY TABLE TO [계정명];
-- GRANT CONNECT, RESOURCE, DBA TO [계정명];

insert into member values (1, '정성균', '남양주', '01000000000', 'sk','sk', 0);
insert into member values (2, '홍금보', '서울', '01011111111', 'abc','abc123', 1);
insert into member values (3, '홍길동', '서울2', '01011112222', 'abc1','abc1231', 1);
insert into member values (4, '손흥민', '서울3', '01011113333', 'abc2','abc1232', 1);
insert into member values (5, '이강인', '서울4', '01011114444', 'abc3','abc1233', 1);
insert into member values (6, '황희찬', '서울5', '01011115555', 'abc4','abc1234', 1);

commit;

select * from member;



