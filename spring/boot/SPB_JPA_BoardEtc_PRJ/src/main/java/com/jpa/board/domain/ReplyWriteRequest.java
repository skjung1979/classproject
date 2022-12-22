package com.jpa.board.domain;

import com.jpa.board.entity.member.Member;
import com.jpa.board.entity.reply.Reply;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ReplyWriteRequest {

    private Long ridx;

    private Long bidx;

    private String reply;

    private Long replyer;

    private String regdate;

    private String updatedate;

    public Reply toReply(){
        return Reply.builder()
                .ridx(ridx)
                .bidx(bidx)
                .reply(reply)
                .replyer(Member.builder().memcd(replyer).build())
                .build();
    }

}
