package com.app.springsecurity.security;


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

    // 성공 했을 때 처리,,, 인증 결과를 받아와야 한다. 사용자 정보, 패스워드 등...
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        log.info("successHandler............................");

        AuthMemberDTO authMemberDTO = (AuthMemberDTO) authentication.getPrincipal(); // 여기에 커스텀 유저의 인증 정보를 가져온다.

        String pw = request.getParameter("password");

        log.info(">>>>>>>>>>>>> pw" + pw);

        boolean passResult = passwordEncoder.matches(pw, authMemberDTO.getPassword()); // 인코더에서 비교하는 것이다.

        if (passResult){
            response.sendRedirect("/login?error");
        }

        log.info(">>>>>>>>>>>>>>>>>>authMemberDTO.getAuthorities()" + authMemberDTO.getAuthorities());

        // ROLE_ADMIN ROLE_MEMBER
        List<String> roleNames = new ArrayList<>();

        for (GrantedAuthority authority : authMemberDTO.getAuthorities()){
            // 권한의 이름을 String 리스트에 저장
            roleNames.add(authority.getAuthority());
        }

        if (roleNames.contains("ROLE_ADMIN")){
            response.sendRedirect("/sample/admin");
        } else if (roleNames.contains("ROLE_USER")){
            response.sendRedirect("/sample/member");
        }
    }
}
























