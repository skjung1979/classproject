package com.app.board.security;

import com.app.board.domain.MemberLoginInfo;
import com.app.board.entity.BoardMember;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUser  extends User {

    private MemberLoginInfo memberLoginInfo;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, MemberLoginInfo memberLoginInfo) {
        super(username, password, authorities);
        this.memberLoginInfo = memberLoginInfo;
    }

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, MemberLoginInfo memberLoginInfo) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.memberLoginInfo = memberLoginInfo;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "memberLoginInfo=" + memberLoginInfo +
                '}';
    }
}
