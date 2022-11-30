package com.bbs.springrestprj.mapper;

import com.bbs.springrestprj.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRegMapper {

    int insertMember(Member member);
}
