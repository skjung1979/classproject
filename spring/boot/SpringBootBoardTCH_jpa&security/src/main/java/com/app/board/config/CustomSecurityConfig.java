package com.app.board.config;

import com.app.board.security.Custom403Handler;
import com.app.board.security.CustomLoginSuccessHandler;
import lombok.extern.log4j.Log4j2;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
@Log4j2
public class CustomSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // Security의 설정
        // 1. 요청(URL) 에 대한 인증과 허가에 대한 설정
        http.authorizeHttpRequests()
                .antMatchers("/board/**","/reply/**","/todo/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll();

/*                .antMatchers("/sample/sample").authenticated() // 해당 경로 요청시 인증을 요구
                .antMatchers("/sample/all").permitAll()
                .antMatchers("/sample/member").hasRole("USER")
                .antMatchers("/sample/admin").hasRole("ADMIN");*/


        // 2. form 기반 인증처리 : 커스텀 로그인 페이지 설정  -> 성공시 처리하는 핸들러 객체 등록
//        http.formLogin().loginPage("/auth/login").successHandler(successHandler());
        http.formLogin().loginPage("/auth/login");

        // 3. 허가 실패  403 : 권한 부족의 처리 핸들러 등록
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());

        // 4. 로그아웃
        http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");

        // 5. 자동로그인
        http.rememberMe().key("123456789").rememberMeParameter("remember-me").tokenValiditySeconds(60*60*24);


        return http.build();
    }



    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new CustomLoginSuccessHandler();
    }

    public AccessDeniedHandler accessDeniedHandler() {
        return new Custom403Handler();
    }




    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        log.info("------------web configure-------------------");

        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());

    }
}
