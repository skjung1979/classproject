package com.potato.nedonado.service.user;

import com.potato.nedonado.mapper.UserMapper;
import com.potato.nedonado.model.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserMyPageReadService {

    @Autowired
    private UserMapper userMapper;

    public UserInfo selectUserByIdx(long userIdx) throws SQLException{
        return userMapper.selectUserByIdx(userIdx).toUserInfo();
    }
}
