package com.bbs.springrestprj.service.board;

import com.bbs.springrestprj.domain.board.BoardDTO;
import com.bbs.springrestprj.mapper.board.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Log4j2
public class BoardService {

    @Autowired(required = false)
    private BoardMapper boardMapper;

    public List<BoardDTO> listBoards() {

        return boardMapper.listBoards();
    }

    public BoardDTO listOneBoard(Integer bno) {

        return boardMapper.listOneBoard(bno);
    }

    public int addBoard(BoardDTO boardDTO) {

        return boardMapper.addBoard(boardDTO);
    }

    public int editBoard(BoardDTO boardDTO) {

        return boardMapper.editBoard(boardDTO);
    }

    public int removeBoard(Integer bno) {

        return boardMapper.removeBoard(bno);
    }

    public int maxBno() {

        return boardMapper.maxBno();
    }

    public String membernm(int i) {

        return boardMapper.membernm(7);
    }
}
