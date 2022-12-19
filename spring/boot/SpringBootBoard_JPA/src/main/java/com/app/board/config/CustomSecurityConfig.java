package com.app.board.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChian filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // 권한에 따른 접속 제한 설정
        // USER : /board/**, /reply/**, /todo/**
        // ADMIN : /admin/**
        // 나머지 요청 경로: 모두 허가
        http.authorizeHttpRequests()
                .antMatchers("/board/**", "/reply/**", "/todo/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll();

        // form 로그인 페이지에 대한 설정, 성공시 처리 핸들러 등록
        //http.formLogin(); // 이대로하면 security가 제공하는 기본 로그인 폼
        http.formLogin().loginPage("/auth/login"); // 이대로 하면 로그인하기 이전 페이지로 로그인 후 머문다.
        // ==> /auth/login요청의 페이지는 사용자가 직접 만든(커스터마이징한) 페이지

        // 로그아웃
        http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
        // ==> /auth/logout security가 자동 매핑한다. 페이지를 만들 필요 없음
        // ==> .logoutSuccessUrl()은 원하는 페이지로 이동한다. 디폴트 페이지는 로그인 페이지

        // 자동 로그인
        //http.rememberMe(); // 여기까지만 해도 자동 로그인 가능하다.
        http.rememberMe()
                .key("123456789")
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(60*60*60*24*7);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
