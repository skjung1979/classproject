package com.jpa.board.domain;

import com.jpa.board.entity.member.Member;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberRegisterRequest {

    private String memid;

    private String password;

    private String memname;

    private MultipartFile mphoto;

    public Member toMember(){
        return Member.builder()
                .memname(memname)
                .memid(memid)
                .password(password)
                .build();
    }
}
