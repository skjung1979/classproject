package com.app.board.service;

import com.app.board.entity.BoardMember;
import com.app.board.repository.BoardMemberRepository;
import com.app.board.security.CustomUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private BoardMemberRepository boardMemberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info(">>>>>>>>>>>>>>>>>>>> loadUserByUsername >>>>>>>>>>>>> " + username);

        Optional<BoardMember> result = boardMemberRepository.findByUserid(username);

        if (result.isEmpty()) {
            throw new UsernameNotFoundException("회원의 아이디 또는 비밀번호 확인!!!");
        }

        // 회원의 정보, 권한 정보로 CustomUser 인스턴스 생성하고 반환하기
        BoardMember boardMember = result.get();

        // 권한 데이터 처리
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + boardMember.getRole()));

        CustomUser user = new CustomUser(boardMember.getUserid(), boardMember.getPassword(), authorities, boardMember);

        return user;
    }
}
