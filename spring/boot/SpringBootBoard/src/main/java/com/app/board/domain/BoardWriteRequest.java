package com.app.board.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardWriteRequest {

    // 폼에서 지정한 name과 같아야 한다.
    private String title;
    private String writer;
    private String content;
    // 원본 private MultipartFile formFile;
    private List<MultipartFile> formFile;  ////////////////////////// 여기 변경함

    public BoardDTO toBoardDTO(){

        return BoardDTO.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }

}
