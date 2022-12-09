package com.app.board.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ReplyDTO {

//    rno	int
//    bno	int
//    reply	varchar(1000)
//    replyer	varchar(50)
//    replyDate	date
//    updateDate	date

    private int rno;
    private int bno;
    private String reply;
    private String replyer;
    private String replydate;
    private String updatedate;

}
