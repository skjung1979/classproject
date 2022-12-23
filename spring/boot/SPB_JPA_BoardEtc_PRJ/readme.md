### **1. 프로젝트 기본 기획**
#### **글쓰기 게시판 구현**

### **2. 구현 기능**
- 회원 가입 (프로필 사진 첨부, ID중복, 비번일치 체크)
- 로그인 / 로그아웃(invalidate(x), setAttribute(null))
- 댓글 (입력 / 수정 / 삭제 / 리스트)
- 게시판 (글쓰기 파일첨부, 페이징, 조회수)
- 인터셉터 (게시글 쓰기, 댓글 쓰기 로그인 필수)

### **3. 기술/구조**
- 웹표준 + bootstrap
- DBMS - Mysql
- Spring Boot + Thymeleaf
- Rest API: 댓글, ID 중복 체크
- JPA

### **4. DBMS - 생성 테이블명**
- 게시판 테이블: t_board
- 회원 테이블: t_member
- 댓글 테이블: t_reply

### **5. 프로젝트 구조**
html > controller > service > repository
