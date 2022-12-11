-- 테이블 삭제
drop table tbl_reply;
drop table tbl_board;

-- 테이블 생성 Board DDL
CREATE TABLE `tbl_board` (
  `bno` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) COLLATE utf8mb3_bin NOT NULL,
  `content` varchar(2000) COLLATE utf8mb3_bin NOT NULL,
  `writer` varchar(50) COLLATE utf8mb3_bin NOT NULL,
  `photo` varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  `regdate` date DEFAULT (now()),
  `updatedate` date DEFAULT (now()),
  PRIMARY KEY (`bno`)
);

CREATE TABLE `tbl_reply` (
  `rno` int NOT NULL AUTO_INCREMENT,
  `bno` int NOT NULL,
  `reply` varchar(1000) COLLATE utf8mb3_bin NOT NULL,
  `replyer` varchar(50) COLLATE utf8mb3_bin NOT NULL,
  `replyDate` date DEFAULT (now()),
  `updateDate` date DEFAULT (now()),
  PRIMARY KEY (`rno`),
  KEY `fk_reply_board` (`bno`),
  CONSTRAINT `fk_reply_board` FOREIGN KEY (`bno`) REFERENCES `tbl_board` (`bno`)
) ;

desc tbl_board;
select * from tbl_board order by bno desc;
select * from tbl_board order by bno desc limit 0, 3;
select * from tbl_reply;
desc tbl_reply;
delete from tbl_board where bno=1;

-- 더미 데이터 넣기
INSERT INTO `project`.`tbl_board` (`title`, `content`, `writer`) VALUES('test82','테스트 내용','쏜');
INSERT INTO `project`.`tbl_board` (`title`, `content`, `writer`) VALUES('test83','테스트 내용','쏜');
INSERT INTO `project`.`tbl_board` (`title`, `content`, `writer`) VALUES('test84','테스트 내용','쏜');
INSERT INTO `project`.`tbl_board` (`title`, `content`, `writer`) VALUES('test85','테스트 내용','쏜');
INSERT INTO `project`.`tbl_board` (`title`, `content`, `writer`) VALUES('test86','테스트 내용','쏜');
INSERT INTO `project`.`tbl_board` (`title`, `content`, `writer`) VALUES('test77','테스트 내용','쏜');
INSERT INTO `project`.`tbl_board` (`title`, `content`, `writer`) VALUES('test78','테스트 내용','쏜');
INSERT INTO `project`.`tbl_board` (`title`, `content`, `writer`) VALUES('test79','테스트 내용','쏜');
INSERT INTO `project`.`tbl_board` (`title`, `content`, `writer`) VALUES('test80','테스트 내용','쏜');

insert into tbl_reply (bno, reply, replyer, replyDate) values (225, '댓글225-01','작성자225', now());
insert into tbl_reply (bno, reply, replyer, replyDate) values (225, '댓글225-02','작성자225', now());
insert into tbl_reply (bno, reply, replyer, replyDate) values (225, '댓글225-03','작성자225', now());
insert into tbl_reply (bno, reply, replyer, replyDate) values (224, '댓글224-01','작성자224', now());
insert into tbl_reply (bno, reply, replyer, replyDate) values (224, '댓글224-02','작성자224', now());
insert into tbl_reply (bno, reply, replyer, replyDate) values (224, '댓글224-03','작성자224', now());
insert into tbl_reply (bno, reply, replyer, replyDate) values (223, '댓글223-01','작성자223', now());
insert into tbl_reply (bno, reply, replyer, replyDate) values (223, '댓글223-02','작성자223', now());
insert into tbl_reply (bno, reply, replyer, replyDate) values (223, '댓글223-03','작성자223', now());

-- 정성균 추가
create table tbl_user(
usercd int not null auto_increment,
userId varchar(50) not null,
userPw varchar(50) not null,
userName varchar(50) not null,
userAddrZip varchar(10),
userAddr1 varchar(45),
userAddr2 varchar(45),
userAddr3 varchar(45),
userPhone varchar(20),
userEmail varchar(50),
byear char(4),
bmonth char(2),
bday char(2),
photo varchar(50),
uuid varchar(50),
regDate Date,
primary key (usercd)
);

select *  from tbl_user;

insert into tbl_user (userId, userPw, userName, userAddrZip, userAddr1, userAddr2, userAddr3, userPhone, userEmail, byear, bmonth, bday, photo, regDate) values ('aaa', 'aaa', '정성균', '12177', 'userAddr1', 'userAddr2', 'userAddr3', '01011112222', 'sk@gmail.com', '1807', '05', '06', '1001000.jpg', now());






