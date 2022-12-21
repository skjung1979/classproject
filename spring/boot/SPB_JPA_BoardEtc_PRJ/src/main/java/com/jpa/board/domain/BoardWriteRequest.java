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
public class BoardWriteRequest {

    private String title;

    private String content;

    private Long writer;

    private MultipartFile bphoto;

    public Board toBoard(){
        return Board.builder()
                .title(title)
                .content(content)
                .writer(Member.builder().memcd(writer).build())
                .build();
    }
}
