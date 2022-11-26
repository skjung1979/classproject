package com.todo.todomybatis.service.login;

import com.todo.todomybatis.domain.member.Member;
import com.todo.todomybatis.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired(required = false)
    private LoginMapper loginMapper;

    public Member login(String userid, String userpw) throws Exception {

        //@Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        Member member = loginMapper.selectByUidPw(userid, userpw);

        return member;
    }

    public int updateUUID(int seq, String toString) throws Exception {

        //@Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int result = loginMapper.updateUUID(seq, toString);

        return result;
    }

}
