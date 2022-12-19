package com.app.board;

import com.app.board.entity.BoardMember;
import com.app.board.repository.BoardMemberRepository;
import com.app.board.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class BoardMemberRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Autowired
    private BoardMemberRepository boardMemberRepository;

    @Test
    public void saveTest(){

        BoardMember boardMember = BoardMember.builder()
                .userid("cool")
                .username("COOL")
                .password(encoder.encode("1111"))
                .role("USER")
                .regdate(LocalDateTime.now())
                .editdate(LocalDateTime.now())
                .build();

        /*log.info(encoder.encode("1111").length());*/

        BoardMember member = boardMemberRepository.save(boardMember);

        log.info(member);


    }
}
