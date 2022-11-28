package com.todo.todomybatis.domain.member;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberRegRequest {

    // member_td의 컬럼들
//    seq	int
//    membernm	varchar(30)
//    memberid	varchar(45)
//    memberpw	varchar(45)
//    memberphone	varchar(45)
//    memberemail	varchar(45)
//    uuid	varchar(60)
//    uphoto	varchar(45)

    // 아래 변수명은 회원가입 폼에서 가져오는 name과 같아야 한다.
    @NotBlank(message="빈값이면 안됩니다.")
    private String username;
    @NotEmpty(message="빈값이면 안됩니다.")
    private String userid;
    @NotEmpty(message="빈값이면 안됩니다.")
    private String userpw;
    private String userphone;
    @Email(message = "이메일 형식에 맞춰 입력해주세요.")
    private String useremail;
    private MultipartFile userphoto;

// Member의 참조변수들
//private int seq;
//    private String membernm;
//    private String memberid;
//    private String memberpw;
//    private String memberphone;
//    private String memberemail;
//    private String uuid;
//    private String uphoto;

    public Member toMember(){

        Member member = Member.builder()
                .membernm(this.username)
                .memberid(this.userid)
                .memberpw(this.userpw)
                .memberphone(this.userphone)
                .memberemail(this.useremail)
                .uphoto(String.valueOf(this.userphoto))
                .build();

        return member;
    }

}
