package com.app.board.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BoardRegRequestDTO {

    private String title;
    private String content;
    private String writer;
    private MultipartFile photo;

    public BoardDTO toBoardDTO(){
        return BoardDTO.builder()
                .title(this.title)
                .content(this.content)
                .writer(this.writer)
                .build();
    }

}