package com.app.board.service.user;

import com.app.board.domain.UserDTO;
import com.app.board.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserLoginService {

    @Autowired
    private UserMapper userMapper;

    public UserDTO selectByIdPw(String userId, String userPw) throws SQLException {

        UserDTO userDTO = userMapper.selectByIdPw(userId, userPw);

        return userDTO;
    }
}
