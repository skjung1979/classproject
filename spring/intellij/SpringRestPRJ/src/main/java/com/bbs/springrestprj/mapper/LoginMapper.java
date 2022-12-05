package com.bbs.springrestprj.mapper;

import com.bbs.springrestprj.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    int updateUUID(int seq, String toString);

    @Select("select * from member_td where memberid=#{param1} and memberpw=#{param2}")
    Member selectByUidPw(@Param("param1") String userid, @Param("param2") String userpw);

    //@Select("select * from member_td where uuid=#{param1}")
    Member selectByUUID(String uuid);
}
