package com.bbs.springrestprj.domain.board;

import lombok.*;

import java.time.LocalDate;

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
    private LocalDate date;
    private LocalDate updatedate;


}
