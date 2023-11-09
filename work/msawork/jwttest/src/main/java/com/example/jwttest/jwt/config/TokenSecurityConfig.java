package com.example.jwttest.jwt.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity(debug = false)
@RequiredArgsConstructor
public class TokenSecurityConfig {

    private final CorsFilter corsFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.sessionManagement(session -> {
            // 세션을 사용하지 않겠다는 정의를 해줘야 함 (토큰을 사용할것이기 때문에)
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilter(corsFilter)
//                .addFilterBefore(new MyTestFilter1(), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new MyTestFilter3(), CorsFilter.class)
//                .addFilterBefore(new MyTestFilter2(), CorsFilter.class)
                // 사용자 지정 필터가 해당 필터 전에 실행되도록
                // 스프링 시큐리티 기본 로그인폼을 사용하지 않음
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers("/api/**")
                .access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/admin/api/**")
                .access("hasRole('ADMIN')")
                .anyRequest()
                .permitAll()
        ;


        return httpSecurity.build();
    }
}
