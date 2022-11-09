package com.firstcoding.firstapp.member;

// Beans 형태 => 모든 변수는 private, 기본 생성자 가져야함, 각 변수의 게터/세터 만듬
// DTO, VO
public class Member {

    // id, pw, name
    private String id;
    private String pw;
    private  String name;

    // 기본 생성자
    public Member() {
    }

    public Member(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    // 게터, 세터
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo(){
        return this.id + "(" + this.name + ")";
    }

    @Override
    public String toString() {
        return "member{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
