package com.app.springsecurity.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 이것을 설정해야 @Bean 설정 가능
@Log4j2
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Security의 설정
        // 1. 요청(url)에 대한 인증과 허가에 대한 설정
        // 2. form 기반 인증처리: 커스텀 로그인 페이지 -> 성공시 커스텀 로그인 석세스 핸들러 객체 등록
        // 3. 허가에 대한 실패 403: 권한 부족의 처리 핸들러 등록
        // 4. 로그아웃
        // 5. 자동로그인
        // ==> 모두 HttpSecurity http로 처리가 가능하다.
        return http.build();
    }

    // 테스트 환경


}
