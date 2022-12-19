package com.app.board.security;

import com.app.board.entity.BoardMember;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {

    private BoardMember member; // 추가적인 회원의 정보

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, BoardMember member) {
        super(username, password, authorities);
        this.member = member;
    }

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, BoardMember member) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.member = member;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "member=" + member +
                '}';
    }
}
