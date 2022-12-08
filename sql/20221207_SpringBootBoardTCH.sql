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

delete from tbl_board where bno=1;
update tbl_board set title=, contenct=, writer=, photo=, where bno=;











