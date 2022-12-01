package com.bbs.springrestprj.domain.reply;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReplyDTO {

    private int rno;
    private String userid;
    private String boardid;
    private String content;
    private String regdate;
}
