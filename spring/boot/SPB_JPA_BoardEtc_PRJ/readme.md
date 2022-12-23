# JAVA OOP mini Project
####홀인원(스크린골프예약시스템)
<br>
>회원 가입 후 로그인을 통해 스크린 골프 타석을 예약하는 시스템으로, 예약일은 로그인한 시점의 날짜이며, 예약 시간은 타석(hall)테이블에 등록된 시간 리스트 중에 예약 가능하다. <br>

<br>
## 기술/구조
* JAVA - 주요 기능

	* `회원가입`
    * `로그인`
    * `예약 가능 여부 확인`
    * `타석 예약 / 변경 / 삭제`
    * `회원 조회 / 삭제`
	
* DBMS - ERD 테이블 구성
    [![](https://github.com/skjung1979/classproject/blob/main/images/dbdesign.png?raw=true)](https://github.com/skjung1979/classproject/blob/main/images/dbdesign.png?raw=true)
* SQL - 사용된 쿼리문

    > select * from hall order by hallno
	select * from hall where hallresvyn = 'y' order by hallno
	select * from member
	select * from member where membergrade !=0 order by memberno
	select * from member where memberid=? and memberpwd=?
	select * from member where memberno=?
	select * from reservation
	select * from reservation where hallno = ?
	select * from reservation where memberno=? order by reservno
	select * from reservation where reservno=?
	select hallstime, halletime from hall where hallno=?
	select memberid from member where memberid=?
	update hall set hallresvyn=? where hallno=?
	update hall set hallstime=?, halletime=? where hallno=?
	update reservation set reservtime=? where reservno=?
	insert into hall values((select max(hallno)+1 from hall), ?, ?, ?)
	insert into member values(memberno_seq.nextval, ?, ?, ?, ?, ?, ?)
	insert into reservation values(reservno_seq.nextval, ?, ?, sysdate, ?)
	delete from hall where hallno=?
	delete from member where membername=?
	delete from reservation where reservno=?

<br>
## 프로젝트 구조
[![](https://github.com/skjung1979/classproject/blob/main/images/flowchart.png?raw=true)](https://github.com/skjung1979/classproject/blob/main/images/flowchart.png?raw=true)
<br>

## 소스코드 
* [전체 소스코드 GITHUB LINK ](https://github.com/HS0430/miniProject)
<br>

## 프로젝트 PPT 
* [Link](https://docs.google.com/presentation/d/198-wc4FJwJjXb1vgX7rnfxAM-pQ9KGxS/edit?usp=sharing&ouid=118102209175623888333&rtpof=true&sd=true)
<br>

## 개인별 구현하면서 겪었던 어려움 
* **고민** <br>
작업 시간이 부족하여 타석관리에 대한 코딩을 마무리하지 못했다.<br>

* **문제** <br>
소스파일을 하나로 구성하여 코딩하였는데, 작업자간의 충돌이 발생함<br>
--> 소스파일을 각자 맡은 파트로 세분화 생성하여 작업하였음
<br>

* **조인이 많은 SQL 문**  <br>
zmrp

* **협업** 과정에서 시간이 많이 소요됨 <br>
또 설명


## 테스트 안내 
**데이터베이스 초기세팅이 필요합니다.** 

**1. 데이터베이스 세팅 :**
* hall테이블에 샘플 데이터가 있어야 타석 예약이 가능합니다.
> insert into hall values(1, 'Y', 18, 10);
insert into hall values(2, 'Y', 18, 10);

* 회원 가입할 때 회원번호 시퀀스
> CREATE SEQUENCE  "ONE"."MEMBERNO_SEQ"  MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 START WITH 9 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;

* 예약 할때 예약번호 시퀀스
> CREATE SEQUENCE  "ONE"."RESERVNO_SEQ"  MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;

<br>
**2. 관리자 계정 :**
* ID : aaa
* PW : aaa
<br>

**3. 사용자 계정 :**
* ID : one
* PW : one1234
<br><br>