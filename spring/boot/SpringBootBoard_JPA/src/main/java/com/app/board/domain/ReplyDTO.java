package com.app.board.domain;

import com.app.board.entity.BoardMember;
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
    private Integer replyer; // String -> Integer로 변경함(22.12.19)
    private String replydate;
    private String updatedate;

    public Reply toReplyEntity(){
        return Reply.builder()
                .rno(rno)
                .bno(bno)
                .reply(reply)
                .replyer(BoardMember.builder().idx(replyer).build())
                //.replydate(LocalDate.parse(replydate)) // null이 들어오므로 받지 않는다.
                .build();
    }

}
