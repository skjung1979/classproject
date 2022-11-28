package com.todo.todomybatis.domain.member;

import com.todo.todomybatis.domain.login.LoginInfo;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Member {

/*    seq	int	NO	PRI		auto_increment
    membernm	varchar(30)	YES
    memberid	varchar(45)	NO
    memberpw	varchar(45)	NO
    memberphone	varchar(45)	YES
    memberemail	varchar(45)	YES
    uuid	varchar(60)	YES*/

    private int seq;
    @NotBlank(message="빈값이면 안됩니다.")
    private String membernm;
    @NotEmpty(message="빈값이면 안됩니다.")
    private String memberid;
    @NotEmpty(message="빈값이면 안됩니다.")
    private String memberpw;
    private String memberphone;
    @Email(message = "이메일 형식에 맞춰 입력해주세요.")
    private String memberemail;
    private String uuid;
    private String uphoto;

// LogingInfo 참조변수들
//    private int seq;
//    private String memberid;
//    private String membernm;
//    private String memberphone;
//    private String memberemail;
//    private String uphoto;
    public LoginInfo toLoginInfo(){

        LoginInfo loginInfo = LoginInfo.builder()
                .seq(seq)
                .memberid(this.memberid)
                .membernm(this.membernm)
                .memberphone(this.memberphone)
                .memberemail(this.memberemail)
                .uphoto(this.uphoto)
                .build();

        return loginInfo;
    }

}
