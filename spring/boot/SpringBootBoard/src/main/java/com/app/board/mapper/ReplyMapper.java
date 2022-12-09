package com.app.board.mapper;

import com.app.board.domain.ReplyDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReplyMapper {

    @Select("select * from tbl_reply where bno=#{bno}")
    List<ReplyDTO> selectAll(int bno);

    @Insert("insert into tbl_reply (bno, reply, replyer, replyDate) values (#{bno}, #{reply}, #{replyer}, now())")
    @Options(useGeneratedKeys = true, keyProperty = "rno", keyColumn = "rno") // 이렇게 설정하면 ReplyDTO에 rno가 생성된 것으로 업데이트가 된다.
    int insertReply(ReplyDTO replyDTO);


}
