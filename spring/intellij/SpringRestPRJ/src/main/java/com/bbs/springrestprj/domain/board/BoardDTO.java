package com.bbs.springrestprj.domain.board;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardDTO {

    private int bno;
    private String title;
    private String content;
    private String writer;
    private String regdate;
    private String updatedate;


}
