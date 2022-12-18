package com.app.board.domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class BoardArticleDTO {

    private int bno;
    private String title;
    private int replycnt;
    private String content;
    private String writer;
    private String photo;
    private LocalDate regdate;
    private LocalDate updatedate;

}
