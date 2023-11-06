package com.example.springsecuritytest.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {

    // 메모리로 사용자를 관리할 수 있도록 설정할 수 있는 객체
    @Bean
    public InMemoryUserDetailsManager createUser() {
        // 유저를 생성할때 유저 디테일을 사용한다.
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("jun1")
                .password("jun")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
    }

    // 기본 필터체인은 모든 페이지를 검증
    // 첫번째 페이지를 모두 허용하고 나머지만 검증하도록 변경
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> {
            // 최초 index 페이지를 response하는 / 요청만 모든 사용자에게 허용하고
            // 나머지는 인증이 된 사용자들만 접속할 수 있도록
            request.antMatchers("/")
                    .permitAll()
                    .anyRequest()
                    .authenticated();})
                .formLogin(login ->
                        login.loginPage("/mylogin")
                                .permitAll()
                                .defaultSuccessUrl("/", true)
                                .failureUrl("/login-error")
                )
                .csrf().disable(); // 시큐리티 로그인 페이지가 실행되도록 처리 (사용자 정의 페이지 등록 가능)
        return http.build();
    }

    // css와 javascript, image는 시큐리티 인증하지 않고 처리
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> {
          web.ignoring()
                  .requestMatchers(
                          PathRequest.toStaticResources().atCommonLocations()
                  );
        };
    }

}
