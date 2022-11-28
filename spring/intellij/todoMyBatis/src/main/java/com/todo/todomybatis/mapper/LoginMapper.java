package com.todo.todomybatis.mapper;

import com.todo.todomybatis.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    int updateUUID(int seq, String toString);

    @Select("select * from member_td where memberid=#{param1} and memberpw=#{param2}")
    Member selectByUidPw(String userid, String userpw);

    //@Select("select * from member_td where uuid=#{param1}")
    Member selectByUUID(String uuid);
}
