package com.bbs.springrestprj.mapper.board;

import com.bbs.springrestprj.domain.board.BoardDTO;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface BoardMapper {
//    @Select("select * from tbl_board")
    @Select("select a.bno, a.title, a.content, a.writer, a.regdate, a.updatedate, ifnull(b.rcnt,0) as rcnt from tbl_board a left join (select boardid, count(rno) as rcnt from reply group by boardid) b on a.bno=b.boardid")
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

    @Select("select a.bno, a.title, a.content, a.writer, a.regdate, a.updatedate, ifnull(b.rcnt,0) as rcnt from tbl_board a left join (select boardid, count(rno) as rcnt from reply group by boardid) b on a.bno=b.boardid order by a.bno desc limit #{param1}, #{param2}")
    List<BoardDTO> listBoardsForPaging(@Param("param1") int i, @Param("param2") int countPerPage);

    @Select("select count(*) from tbl_board")
    int selectTotalCount();
}
