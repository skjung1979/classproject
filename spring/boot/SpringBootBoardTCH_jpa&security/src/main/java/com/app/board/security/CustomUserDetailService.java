package com.app.board.security;

import com.app.board.entity.BoardMember;
import com.app.board.repository.BoardMemberRepository;
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

        log.info(" >>>>>>>>>>   loadUserByUsername => " + username);

        Optional<BoardMember> result = boardMemberRepository.findByUserid(username);

        if(result.isEmpty()){
            throw new UsernameNotFoundException("Check User Email");
        }

        BoardMember boardMember = result.get();
        log.info(">>>>>>>>>>>>>>>  member => " + boardMember);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+boardMember.getRole()));

        /*for(MemberRole memberRole : member.getRoleSet()){
            // ROLE_ADMIN ROLE_USER
            authorities.add(new SimpleGrantedAuthority("ROLE_"+memberRole.name()));
        }*/

        CustomUser customUser = new CustomUser(boardMember.getUserid(), boardMember.getPassword(),authorities, boardMember.toMemberLoginInfo());

        return customUser;
    }
}
