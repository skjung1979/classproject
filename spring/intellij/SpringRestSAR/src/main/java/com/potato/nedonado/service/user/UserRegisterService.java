package com.potato.nedonado.service.user;

import com.potato.nedonado.mapper.UserMapper;
import com.potato.nedonado.model.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;

@Service
public class UserRegisterService {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(UserDTO userDTO) throws SQLException{

        userDTO.setJoinDate(new Date().getTime());
        return userMapper.insertUser(userDTO);
    }

}
