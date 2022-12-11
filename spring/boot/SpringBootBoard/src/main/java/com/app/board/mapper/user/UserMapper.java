package com.app.board.mapper.user;

import com.app.board.domain.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

public interface UserMapper {

//    userId varchar(50) not null,
//    userPw varchar(50) not null,
//    userName varchar(50) not null,
//    userAddrZip varchar(10),
//    userAddr1 varchar(45),
//    userAddr2 varchar(45),
//    userAddr3 varchar(45),
//    userPhone varchar(20),
//    userEmail varchar(50),
//    byear char(4),
//    bmonth char(2),
//    bday char(2),
//    photo varchar(50),
//    uuid varchar(50),
//    regDate Date,

    @Insert("insert into tbl_user (userId, userPw, userName, userAddrZip, userAddr1, userAddr2, userAddr3, userPhone, userEmail, byear, bmonth, bday, photo, regDate) values (#{userId}, #{userPw}, #{userName}, #{userAddrZip}, #{userAddr1}, #{userAddr2}, #{userAddr3}, #{userPhone}, #{userEmail}, #{byear}, #{bmonth}, #{bday}, #{photo}, now())")
    int insertUser(UserDTO userDTO) throws SQLException;

    @Select("select * from tbl_user where userId=#{param1} and userPw=#{param2}")
    UserDTO selectByIdPw(String userId, String userPw) throws SQLException;

    @Select("select * from tbl_user where userId=#{userId}")
    UserDTO selectByUserId(String userId) throws SQLException;
}
