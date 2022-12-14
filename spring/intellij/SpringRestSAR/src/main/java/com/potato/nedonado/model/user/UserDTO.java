package com.potato.nedonado.model.user;

import com.potato.nedonado.util.Util;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserDTO {

    @NotEmpty
    private long userIdx;
    private String uuid;

    @NotEmpty
    private String userId;
    @NotEmpty
    private String userPw;

    private String nickname;
    private String nation;
    private String phone;

    @NotEmpty
    @NotNull
    private String location;
    private int byear;
    private int bmonth;
    private int bday;

    @NotEmpty
    private long joinDate;
    private boolean deleted;

    public LoginInfo loginData(){
        return LoginInfo.builder()
                .userIdx(userIdx)
                .uuid(uuid)
                .userId(userId)
                .joinDate(joinDate)
                .nickname(nickname)
                .location(location)
                .deleted(deleted)
                .build();
    }

    public UserInfo toUserInfo(){

        return UserInfo.builder()
                .userIdx(userIdx)
                .userId(userId)
                .nickname(nickname)
                .nation(nation)
                .phone(phone)
                .location(location)
                .byear(byear)
                .bmonth(bmonth)
                .bday(bday)
                .joinDate(Util.convertLongTimestampToString(joinDate))
                .build();
    }
}
