package com.firstcoding.firstapp.login.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Member {

    /*idx	int	NO	PRI		auto_increment
    uid	varchar(45)	NO	UNI
    pw	varchar(45)	NO
    uuid	varchar(45)	YES*/

    private int idx;
    private String uid;
    private String pw;
    private String uuid;



}
