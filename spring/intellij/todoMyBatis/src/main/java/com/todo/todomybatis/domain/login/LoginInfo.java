package com.todo.todomybatis.domain.login;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LoginInfo {

    private int seq;
    private String memberid;
    private String membernm;
    private String memberphone;
    private String memberemail;
    private String uphoto;

}
