package com.app.board.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberLoginInfo {

    private Integer idx;
    private String userid;
    private String username;
}
