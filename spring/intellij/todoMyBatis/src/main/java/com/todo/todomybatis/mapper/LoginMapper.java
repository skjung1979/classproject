package com.todo.todomybatis.mapper;

import com.todo.todomybatis.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.test.context.jdbc.Sql;

@Mapper
public interface LoginMapper {

    int updateUUID(int seq, String toString);

    @Sql("update member_td set uuid=#{param2} where seq=#{param1}")
    Member selectByUidPw(String userid, String userpw);

    @Sql("select * from member_td where uuid=#{uuid}")
    Member selectByUUID(String uuid);
}
