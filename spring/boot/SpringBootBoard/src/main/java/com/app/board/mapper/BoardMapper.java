package com.app.board.mapper;

import com.app.board.domain.BoardArticleDTO;
import com.app.board.domain.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("select * from tbl_board")
    List<BoardDTO> selectAll();

    //List<BoardDTO> selectList(@Param("start") int start, @Param("count") int count);
    //@Select("select * from tbl_board order by bno desc limit #{start},#{count}")

    @Select("select *, (select count(*) from tbl_reply r where r.bno=b.bno) as replycnt from tbl_board b order by b.bno desc limit #{start},#{count}")
    List<BoardArticleDTO> selectList(@Param("start") int start, @Param("count") int count);

    @Select("select count(*) from tbl_board")
    Integer totalCount();

    // 게시글 하나의 정보
    @Select("select * from tbl_board where bno=#{no}")
    BoardDTO selectByBno(int bno);

    @Insert("insert into tbl_board (title, content, writer, photo) values (#{title}, #{content}, #{writer}, #{photo})")
    Integer insert(BoardDTO boardDTO) throws SQLException;

    @Delete("delete from tbl_board where bno=#{bno}")
    Integer deleteByBno(int bno);

    @Update("update tbl_board set title=#{title}, content=#{content}, writer=#{writer}, photo=#{photo}, updatedate=now() where bno=#{bno}")
    Integer update(BoardDTO boardDTO) throws SQLException;

    // 파일 여러개 업로드 테스트 중: 파일명만 업데이트...
    @Update("update tbl_board set photo=concat(photo, ' / ', #{param2}) where bno=#{param1}")
    int updatePhoto(int bno, String newFileName);

    @Select("select max(bno) from tbl_board")
    int selectMaxBno();
}
