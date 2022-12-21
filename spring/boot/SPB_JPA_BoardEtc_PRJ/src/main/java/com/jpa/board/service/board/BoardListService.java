package com.jpa.board.service.board;

import com.jpa.board.domain.BoardListPage;
import com.jpa.board.entity.board.Board;
import com.jpa.board.repository.board.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class BoardListService {

    @Autowired
    private BoardRepository boardRepository;

    public BoardListPage getPageList(int pageNum){

        Page<Board> page = boardRepository.findAll(PageRequest.of(pageNum-1, 10, Sort.by("bidx").descending()));

        // 게시물의 리스트
        List<Board> list = page.getContent();

        // 전체 게시물의 개수
        int totalCount = (int) page.getTotalElements();

        BoardListPage boardListPage = new BoardListPage(10, pageNum, list, totalCount);

        return boardListPage;
    }


}
