package com.app.board.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        log.info("successHandler ....................................");

        CustomUser customUser = (CustomUser) authentication.getPrincipal();


        log.info(customUser.getAuthorities());
        // ROLE_ADMIN ROLE_MEMBER
        List<String> roleNames = new ArrayList<>();
        for (GrantedAuthority authority : customUser.getAuthorities()){
            // 권한의 이름을 String 리스트에 저장
            roleNames.add(authority.getAuthority());
        }

        if (roleNames.contains("ROLE_ADMIN")){
            response.sendRedirect("/admin");
        } else if(roleNames.contains("ROLE_USER")){
            response.sendRedirect("/board/list");
        }

    }
}
