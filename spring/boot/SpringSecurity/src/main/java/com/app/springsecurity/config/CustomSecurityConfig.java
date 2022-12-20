package com.app.springsecurity.config;

import com.app.springsecurity.security.Custom403Handler;
import com.app.springsecurity.security.CustomLoginSuccessHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration // 이것을 설정해야 @Bean 설정 가능
@Log4j2
public class CustomSecurityConfig {

    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return new CustomLoginSuccessHandler();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Security의 설정
        // 1. 요청(url)에 대한 인증과 허가에 대한 설정
        http.authorizeHttpRequests()
                .antMatchers("/sample/sample").authenticated() // 해당 경로 요청시 인증(로그인)을 요구한다.
                .antMatchers("/sample/all").permitAll() // 해당 경로는 누구나 접근 가능하다.
                .antMatchers("/sample/member").hasRole("USER") // USER만 접근 가능한다.
                .antMatchers("/sample/admin").hasRole("ADMIN");

        // 2. form 기반 인증처리: 커스텀 로그인 페이지 -> 성공시 커스텀 로그인 석세스 핸들러 객체 등록
        //http.formLogin(); // => 이렇게만 해도 로그인 페이지가 나온다.
        http.formLogin().successHandler(successHandler());

        // 3. 허가에 대한 실패 403: 권한 부족의 처리 핸들러 등록
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());

        // 4. 로그아웃
        http.logout();

        // 5. 자동로그인
        // ==> 모두 HttpSecurity http로 처리가 가능하다.
        http.rememberMe().key("123456789").rememberMeParameter("remember-me").tokenValiditySeconds(60*60*24*7);

        return http.build();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new Custom403Handler();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // 테스트 환경, 임시로!!!
    //@Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails userDetails = User.builder()
//                .username("user1")
//                .password(passwordEncoder().encode("1111"))
//                .roles("USER")
//                .build();
//
//        log.info(">>>>>>>>>>>>>>>> userDetailService >>>>>>>>>>>>>>>>>>>>> : " + passwordEncoder().encode("1111"));
//        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + userDetails);
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }
}
