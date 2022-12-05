package com.app.board.service.board;

import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardDeleteService {

    @Autowired(required = false)
    private BoardMapper boardMapper;

    public int deleteArticle(int bno){
        return boardMapper.deleteBoardArticle(bno);
    }
}