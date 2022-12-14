package com.jpa.board.service.member;

import com.jpa.board.entity.member.Member;
import com.jpa.board.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemberLoginService {

    @Autowired
    private MemberRepository memberRepository;

    public Member selectByIdPw(String memid, String password) {

        return memberRepository.findByMemid(memid, password).get();
    }
}
