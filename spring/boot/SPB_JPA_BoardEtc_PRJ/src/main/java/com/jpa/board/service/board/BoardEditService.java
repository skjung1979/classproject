package com.jpa.board.service.board;

import com.jpa.board.entity.board.Board;
import com.jpa.board.repository.board.BoardRepository;
import com.jpa.board.repository.reply.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardEditService {

    @Autowired
    private BoardRepository boardRepository;

    public Board boardEditView(Long bidx) {

        return boardRepository.findById(bidx).get();
    }
}
