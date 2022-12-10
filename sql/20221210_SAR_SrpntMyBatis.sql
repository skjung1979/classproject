-- SAR 테이블 생성

CREATE TABLE board (
  boardIdx int NOT NULL AUTO_INCREMENT,
  title varchar(200) COLLATE utf8mb3_bin NOT NULL,
  content varchar(2000) COLLATE utf8mb3_bin NOT NULL,
  category varchar(50) COLLATE utf8mb3_bin NOT NULL,
  thumbnail varchar(45) COLLATE utf8mb3_bin DEFAULT NULL,
  imgURL varchar(500),
  price int,
  userIdx int,
  writeDate date,
  PRIMARY KEY (boardIdx)
);

CREATE TABLE boardComment (
  commentIdx int NOT NULL AUTO_INCREMENT,
  boardIdx int,
  userIdx int,
  nickname varchar(50) COLLATE utf8mb3_bin NOT NULL,
  content varchar(2000) COLLATE utf8mb3_bin DEFAULT NULL,
  writeDate date,
  PRIMARY KEY (commentIdx)
);

create table user(
userIdx int not null auto_increment,
userId varchar(50) not null,
UserPw varchar(50) not null,
joinDate date,
location varchar(200),
nickname varchar(100),
phone varchar(100),
byear varchar(10),
bmonth varchar(10),
bday varchar(10),
primary key (userIdx)
);