package com.bbs.springrestprj.domain.board;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardListDTO {

    private int pageNum; // 요청 페이지 번호
    private int psize; // 페이지당 게시글 수
    private int ptotal; // 전체 페이지수

    private int start; // 시작 페이지 넘버
    private int end; // 마지막 페이지 넘버

    private boolean prev;
    private boolean next;

    private List<BoardDTO> dtolist;

    public BoardListDTO(int page, int psize, int ptotal, List<BoardDTO> dtolist){
        this.pageNum = psize;
        this.psize = psize;
        this.ptotal = ptotal;
        this.dtolist = dtolist;
    }


}
