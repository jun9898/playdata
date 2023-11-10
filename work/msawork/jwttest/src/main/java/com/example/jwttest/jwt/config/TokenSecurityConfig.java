package com.example.jwttest.jwt.config;

import com.example.jwttest.jwt.filter.JwtAuthenticationFilter;
import com.example.jwttest.jwt.filter.TokenCheckFilter;
import com.example.jwttest.jwt.service.CustomerSecurityDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class TokenSecurityConfig {

    private final CorsFilter corsFilter;
    private final UserDetailsService customerSecurityDetailService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // DaoAuthenticationProvider는 스프링 시큐리티에서 제공하는 db연동을 위한 provider
    // 커스터마이징한 Provider를 쓰고 싶으면 직접 작성한 Provider를 사용하면 된다
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customerSecurityDetailService);
        //provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        AuthenticationManager manager = new ProviderManager(authenticationProvider());
        return manager;
    }

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
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new TokenCheckFilter(authenticationManager()))
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
