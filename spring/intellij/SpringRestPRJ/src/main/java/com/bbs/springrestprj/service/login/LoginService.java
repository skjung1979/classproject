package com.bbs.springrestprj.service.login;

import com.bbs.springrestprj.domain.member.Member;
import com.bbs.springrestprj.mapper.LoginMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LoginService {

    @Autowired(required = false)
    private LoginMapper loginMapper;

    public Member login(String userid, String userpw) throws Exception {

        return loginMapper.selectByUidPw(userid, userpw);
    }

    public int updateUUID(int seq, String toString) throws Exception {

        return loginMapper.updateUUID(seq, toString);
    }

    public Member selectByUUID(String uuid) throws Exception{
        return loginMapper.selectByUUID(uuid);
    }
}
