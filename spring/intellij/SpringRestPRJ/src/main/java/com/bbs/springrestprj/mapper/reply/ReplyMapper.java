package com.bbs.springrestprj.mapper.reply;

import com.bbs.springrestprj.domain.board.BoardDTO;
import com.bbs.springrestprj.domain.reply.ReplyDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplyMapper {
    @Select("select * from reply")
    List<ReplyDTO> listReplys();

    @Select("select * from reply where rno=#{rno}")
    ReplyDTO listOneReply(Integer rno);

    @Insert("insert into reply (userid, boardid, content, regdate, updatedate) values(#{userid},#{boardid},#{content},#{regdate}, #{updatedate})")
    int addReply(ReplyDTO replyDTO);

    @Update("update reply set userid=#{userid}, boardid=#{boardid}, content=#{content}, regdate=regdate, updatedate=#{updatedate} where rno=#{rno}")
    int editReply(ReplyDTO replyDTO);

    @Delete("delete from reply where bno=#{bno}")
    int removeReply(Integer rno);

    @Select("select ifnull(max(rno), 0) from reply")
    int maxRno();

    @Select("select membernm from member_td where seq=#{i}")
    String membernm(int i);

    @Select("select * from reply where boardid=#{bno}")
    List<ReplyDTO> listReplysByBno(int bno);
}
