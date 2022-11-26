package com.todo.todomybatis.mapper;

import com.todo.todomybatis.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRegMapper {

    int insertTodoMember(Member member);
}
