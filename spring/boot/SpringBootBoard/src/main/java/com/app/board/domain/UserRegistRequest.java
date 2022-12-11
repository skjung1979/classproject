package com.app.board.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserRegistRequest {

    private String uId;
    private String uPw;
    private String uName;
    private String uAddrZip;
    private String uAddr1;
    private String uAddr2;
    private String uAddr3;
    private String uPhone;
    private String uEmail;
    private String byear;
    private String bmonth;
    private String bday;
    private MultipartFile uPhoto;

    public UserDTO toUserDTO(){
        return UserDTO.builder()
                .userId(uId)
                .userPw(uPw)
                .userName(uName)
                .userAddrZip(uAddrZip)
                .userAddr1(uAddr1)
                .userAddr2(uAddr2)
                .userAddr3(uAddr3)
                .userPhone(uPhone)
                .userEmail(uEmail)
                .byear(byear)
                .bmonth(bmonth)
                .bday(bday)
                .build();
    }


}
