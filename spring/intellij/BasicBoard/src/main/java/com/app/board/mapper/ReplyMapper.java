package com.app.board.mapper;

import com.app.board.domain.ReplyDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplyMapper {

    @Select("select * from tbl_reply")
    List<ReplyDTO> selectAll();

    @Select("select * from tbl_reply order by rno desc limit #{start}, #{count}")
    List<ReplyDTO> selectList(@Param("start") int start, @Param("count") int count);

    @Select("select count(*) from tbl_reply")
    int selectTotalCount();

    @Select("select * from tbl_reply where rno=#{rno}")
    ReplyDTO selectByRno(int rno);

    @Insert("insert into tbl_reply (bno, reply, replyer) values (#{bno}, #{reply}, #{replyer})")
    @Options(useGeneratedKeys = true, keyProperty = "rno", keyColumn = "rno")
    int insertReply(ReplyDTO replyDTO);

    @Update("update tbl_reply set bno=#{bno}, reply=#{reply}, replyer=#{replyer}, updatedate=now() where rno=#{rno}")
    int updateReply(ReplyDTO replyDTO);

    @Delete("delete from tbl_reply where rno=#{rno}")
    int deleteReply(int rno);

}