package com.jpa.board.service.member;

import com.jpa.board.entity.member.Member;
import com.jpa.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberIdcheckService {

    @Autowired
    private MemberRepository memberRepository;

    public String idcheck(String memid) {

        Optional<Member> memberOptional = memberRepository.findByMemberId(memid);

        if (memberOptional.isEmpty()) {
            return "ok";
        } else {
            return "no";
        }
    }
}
