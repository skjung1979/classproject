package com.jpa.board.service.member;

import com.jpa.board.entity.member.Member;
import com.jpa.board.repository.MemberRepository;
import com.jpa.board.repository.reply.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemberReadService {
    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Member selectMember(Long memcd){

        Member member = memberRepository.findById(memcd).get();

        return member;
    }
}
