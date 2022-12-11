package com.app.board.service.user;

import com.app.board.domain.UserDTO;
import com.app.board.mapper.user.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@Log4j2
public class UserMypageReadServie {

    @Autowired
    private UserMapper userMapper;

    public UserDTO getUserMypage(String userId) throws SQLException {

        UserDTO userDTO = userMapper.selectByUserId(userId);

        return userDTO;
    }

}
