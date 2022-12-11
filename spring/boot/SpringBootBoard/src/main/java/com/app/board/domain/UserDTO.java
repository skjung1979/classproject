package com.app.board.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserDTO {

    private int usercd;
    private String userId;
    private String userPw;
    private String userName;
    private String userAddrZip;
    private String userAddr1;
    private String userAddr2;
    private String userAddr3;
    private String userPhone;
    private String userEmail;
    private String byear;
    private String bmonth;
    private String bday;
    private String photo;
    private String uuid;
    private String regDate;

}
