package com.bbs.springrestprj.mapper.reply;

import com.bbs.springrestprj.domain.board.BoardDTO;
import com.bbs.springrestprj.domain.reply.ReplyDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplyMapper {
    @Select("select * from tbl_board")
    List<ReplyDTO> listReplys();

    @Select("select * from tbl_board where bno=#{bno}")
    ReplyDTO listOneReply(Integer rno);

    @Insert("insert into tbl_board (title, content, writer, regdate, updatedate) values(#{title},#{content},#{writer},#{regdate},#{updatedate})")
    int addReply(ReplyDTO replyDTO);

    @Update("update tbl_board set title=#{title}, content=#{content}, writer=#{writer}, regdate=regdate, updatedate=#{updatedate} where bno=#{bno}")
    int editReply(ReplyDTO replyDTO);

    @Delete("delete from tbl_board where bno=#{bno}")
    int removeReply(Integer rno);

    @Select("select max(bno) from tbl_board")
    int maxRno();

    @Select("select membernm from member_td where seq=#{i}")
    String membernm(int i);
}
