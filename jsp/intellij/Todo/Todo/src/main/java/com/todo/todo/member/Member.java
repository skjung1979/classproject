package com.todo.todo.member;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Member {

/*    seq	int	NO	PRI		auto_increment
    membernm	varchar(30)	YES
    memberid	varchar(45)	NO
    memberpw	varchar(45)	NO
    memberphone	varchar(45)	YES
    memberemail	varchar(45)	YES
    uuid	varchar(60)	YES*/

    private int seq;
    private String membernm;
    private String memberid;
    private String memberpw;
    private String memberphone;
    private String memberemail;
    private String uuid;

}
