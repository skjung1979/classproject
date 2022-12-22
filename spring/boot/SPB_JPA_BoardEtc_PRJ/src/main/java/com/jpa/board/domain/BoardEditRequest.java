package com.jpa.board.domain;

import com.jpa.board.entity.board.Board;
import com.jpa.board.entity.member.Member;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardEditRequest {

    private Long bidx;

    private int p; // pageNum

    private String title;

    private String content;

    private Long writer;

    private String oldFile;

    private MultipartFile bphoto;

    public Board toBoard(){
        return Board.builder()
                .bidx(bidx)
                .title(title)
                .content(content)
                .writer(Member.builder().memcd(writer).build())
                .bphoto(oldFile)
                .build();
    }
}
