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
