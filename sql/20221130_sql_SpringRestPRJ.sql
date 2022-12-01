-- 프로젝트 SpringRestPRJ 사용 쿼리문들

-- 게시판 테이블 생성 및 설정
create table tbl_board (
 bno INT,
 title varchar(200) not null,
 content varchar(2000) not null,
 writer varchar(50) not null,
 regdate date default (now()), 
 updatedate date default (now())
);
alter table tbl_board add constraint pk_board primary key (bno);
ALTER TABLE `project`.`tbl_board` CHANGE COLUMN `bno` `bno` INT NOT NULL AUTO_INCREMENT;

-- 댓글 테이블 생성 및 설정
create table reply (
 rno INT,
 userid varchar(200) not null,
 boardid varchar(200) not null,
 content varchar(2000) not null,
 regdate date default (now())
);
alter table reply add constraint pk_board primary key (rno);
ALTER TABLE `project`.`reply` CHANGE COLUMN `rno` `rno` INT NOT NULL AUTO_INCREMENT ;


select * from member_td;
select * from tbl_board limit 0, 1;
select * from tbl_board limit 0, 2;
select * from tbl_board;
desc tbl_board;
select max(bno) from tbl_board;
select membernm from member_td where seq=7;
