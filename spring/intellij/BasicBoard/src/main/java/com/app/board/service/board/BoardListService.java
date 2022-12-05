package com.app.board.service.board;

import com.app.board.domain.BoardArticleDTO;
import com.app.board.domain.BoardDTO;
import com.app.board.domain.ReplyDTO;
import com.app.board.domain.BoardListDTO;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardListService {

    @Autowired(required = false)
    private BoardMapper boardMapper;

    private final int countPerPage = 10;

    public BoardListDTO getBoardList(int pageNum){

        // 현재 요청 페이지
        int requestPageNum = pageNum;

        // 요청 페이지의 리스트 항목 ReplyDTO
        //List<ReplyDTO> list = boardMapper.selectAll();
        List<BoardArticleDTO> list = boardMapper.selectList((requestPageNum-1)*10, countPerPage);

        // 전체 게시물 게수
        int totalCountOfArticle = boardMapper.selectTotalCount();

        // 전체 페이지 개수
        int totalCountOfPage = totalCountOfArticle/countPerPage + (totalCountOfArticle%countPerPage>0 ? 1 : 0);

        return BoardListDTO.builder()
                .pageNum(requestPageNum)
                .list(list)
                .totalCountOfArticle(totalCountOfArticle)
                .totalCountOfPage(totalCountOfPage)
                .build();
    }
}