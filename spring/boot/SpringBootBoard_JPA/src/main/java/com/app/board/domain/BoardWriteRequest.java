package com.app.board.domain;

import com.app.board.entity.Board;
import com.app.board.entity.BoardMember;
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

    // 작성자 이름 문자열 -> 작성자의 idx
    private Integer writer;
    private String content;

    private MultipartFile formFile;

    /*public BoardDTO toBoardDTO(){

        return BoardDTO.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }*/

    public Board toBoardEntity(){

        return Board.builder()
                .title(title)
                .content(content)
                .writer(BoardMember.builder().idx(writer).build())
                //.photo(null)
                .build();
    }

}
