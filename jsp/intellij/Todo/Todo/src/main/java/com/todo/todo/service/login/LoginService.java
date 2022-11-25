package com.todo.todo.service.login;

import com.todo.todo.Dao.todo.Dao;
import com.todo.todo.domain.member.Member;
import com.todo.todo.domain.member.MemberRegRequest;
import com.todo.todo.domain.todo.TodoDTO;
import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    private final Dao dao;

    public LoginService(Dao dao){

        this.dao = dao;
    }

    public Member login(String userid, String userpw) throws Exception {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        Member member = dao.selectByUidPw(conn, userid, userpw);

        return member;
    }

    public int updateUUID(int seq, String toString) throws Exception {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int result = dao.updateUUID(conn, seq, toString);

        return result;
    }

}
