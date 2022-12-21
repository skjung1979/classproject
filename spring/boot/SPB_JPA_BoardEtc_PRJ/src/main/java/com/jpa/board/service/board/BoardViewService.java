package com.jpa.board.service.board;

import com.jpa.board.entity.board.Board;
import com.jpa.board.repository.board.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class BoardViewService {

    @Autowired
    private BoardRepository boardRepository;

    public Board selectBoard(Long bidx) {

        return boardRepository.findById(bidx).get();
    }
}
