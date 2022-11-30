package com.bbs.springrestprj.mapper.board;

import com.bbs.springrestprj.domain.board.BoardDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("select * from tbl_board")
    List<BoardDTO> listBoards();

    @Select("select * from tbl_board where bno=#{bno}")
    BoardDTO listOneBoard(Integer bno);

    @Insert("insert into tbl_board (title, content, writer, regdate, updatedate) values(#{title},#{content},#{writer},#{regdate},#{updateddate})")
    ResponseEntity<String> addBoard(BoardDTO boardDTO);

    @Update("update tbl_board set titiel=#{title}, content=#{content}, writer=#{writer}, regdate=regdate, update=#{updatedate}")
    int editBoard(BoardDTO boardDTO);

    @Delete("delete from tbl_board where bno=#{bno}")
    int removeBoard(Integer bno);
}
