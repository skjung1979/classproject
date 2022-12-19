package com.app.board.domain;

import com.app.board.entity.Reply;
import lombok.*;

import java.time.LocalDate;

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

    public Reply toReplyEntity(){
        return Reply.builder()
                .rno(rno)
                .bno(bno)
                .reply(reply)
                .replyer(replyer)
                //.replydate(LocalDate.parse(replydate)) // null이 들어오므로 받지 않는다.
                .build();
    }

}
