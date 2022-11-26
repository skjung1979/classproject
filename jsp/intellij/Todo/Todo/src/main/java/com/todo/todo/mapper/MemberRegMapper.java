package com.todo.todo.mapper;

import com.todo.todo.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRegMapper {

    int insertTodoMember(Member member);
}
