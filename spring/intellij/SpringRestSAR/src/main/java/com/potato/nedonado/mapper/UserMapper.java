package com.potato.nedonado.mapper;

import com.potato.nedonado.model.user.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    String getTime();

    // 회원 가입
    int insertUser(UserDTO userDTO);

    // ud, pw로 로그인
    UserDTO selectByIdAndPw(UserDTO userDTO);

    // 유저 정보 조회
    UserDTO selectUserByIdx(long userIdx);

    // 정보 수정
    long editUserInfo(UserDTO userDTO);

    // 탈퇴 처리
    int deleteUser(UserDTO userDTO);

    // user select by uuid
    UserDTO selectUserByUUID(String uuid);

    // uuid 갱신
    int updateUUIDtoUser(UserDTO userDTO);
}
