package com.app.board.service.board;

import com.app.board.domain.BoardDTO;
import com.app.board.domain.ReplyDTO;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardViewService {

    @Autowired(required = false)
    private BoardMapper boardMapper;

    public BoardDTO readArticle(int bno){
        return boardMapper.selectByBno(bno);
    }
}