package com.todo.todospring.mapper;

import com.todo.todospring.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import java.sql.SQLException;

@Mapper
public interface MemberMapper {

    int insertMember(Member member) throws SQLException;

    Member selectByIdPw(String uid, String pw) throws SQLException;

}
