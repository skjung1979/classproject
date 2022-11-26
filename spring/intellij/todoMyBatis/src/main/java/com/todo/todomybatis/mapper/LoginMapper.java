package com.todo.todomybatis.mapper;

import com.todo.todomybatis.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    int updateUUID(int seq, String toString);

    //@Sql("select * from member_td where memberid=#{param1} and memberpw=#{param2}")
    Member selectByUidPw(String userid, String userpw);

    //@Sql("select * from member_td where uuid=#{uuid}")
    Member selectByUUID(String uuid);
}
