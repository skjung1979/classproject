package com.bbs.springrestprj.service.board;

import com.bbs.springrestprj.domain.board.BoardDTO;
import com.bbs.springrestprj.domain.board.BoardListDTO;
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

    /*한 페이지당 표시하는 게시글 개수*/
    private final int countPerPage = 10;

    public List<BoardDTO> listBoards(int p) {

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

    public BoardListDTO getBoardList(int p) {

        // BoardListDTO의 변수에 해당하는 각각의 값들을 처리하여 리턴해야 한다.

        // 현재 요청 페이지
        int requestPageNum = p;

        // 요청 페이지의 리스트 항목
        //List<BoardDTO> list = boardMapper.listBoardsForPaging((requestPageNum-1)*10, countPerPage);
        List<BoardDTO> list = boardMapper.listBoardsForPaging((requestPageNum-1)*10, countPerPage);

        // 전체 게시글 개수
        int totalCountOfBoard = boardMapper.selectTotalCount();

        // 전체 페이지 개수 => 전체 게시글 개수 / 페이지당 게시글 개수
        // => 여기에 페이지당 개수를 나눈 나머지가 0보다 크다면 페이지수를 1개를 더 해줘야 한다.
        // 그래야 누락없이 마지막 페이지까지 표시 할 수 있다.
        int totalCountPage = totalCountOfBoard / countPerPage + (totalCountOfBoard%countPerPage > 0 ? 1 : 0);

        int end = (int)(Math.ceil(p/10.0)) * 10;
        int start = end - 9;
        int last = (int)(Math.ceil((totalCountOfBoard/(double)countPerPage)));

        end = end > last ? last : end;

        boolean prev = start > 1;
        boolean next = totalCountOfBoard > end * countPerPage;

        return new BoardListDTO(requestPageNum, countPerPage, totalCountPage, start, end, prev, next, list);
    }
}
