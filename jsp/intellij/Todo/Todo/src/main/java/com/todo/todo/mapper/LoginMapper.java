package com.todo.todo.mapper;

import com.todo.todo.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    int updateUUID(int seq, String toString);

    Member selectByUidPw(String userid, String userpw);
}
