package com.app.board.domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BoardArticleDTO {

    private long bno;
    private String title;
    private String content;
    private int replycnt;
    private String writer;
    private LocalDate regdate;
    private LocalDate updatedate;

}