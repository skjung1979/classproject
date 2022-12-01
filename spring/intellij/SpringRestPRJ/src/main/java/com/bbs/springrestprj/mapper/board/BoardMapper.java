package com.bbs.springrestprj.mapper.board;

import com.bbs.springrestprj.domain.board.BoardDTO;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("select * from tbl_board")
    List<BoardDTO> listBoards();

    @Select("select * from tbl_board where bno=#{bno}")
    BoardDTO listOneBoard(Integer bno);

    @Insert("insert into tbl_board (title, content, writer, regdate, updatedate) values(#{title},#{content},#{writer},#{regdate},#{updatedate})")
    int addBoard(BoardDTO boardDTO);

    @Update("update tbl_board set title=#{title}, content=#{content}, writer=#{writer}, regdate=regdate, updatedate=#{updatedate} where bno=#{bno}")
    int editBoard(BoardDTO boardDTO);

    @Delete("delete from tbl_board where bno=#{bno}")
    int removeBoard(Integer bno);

    @Select("select max(bno) from tbl_board")
    int maxBno();

    @Select("select membernm from member_td where seq=#{i}")
    String membernm(int i);
}
