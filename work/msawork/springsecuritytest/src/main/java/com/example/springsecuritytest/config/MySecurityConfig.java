package com.example.springsecuritytest.config;

import com.example.springsecuritytest.service.security.CustomerSecurityDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {

    @Autowired
    CustomerSecurityDetailService customerSecurityDetailService;

    // 메모리로 사용자를 관리할 수 있도록 설정할 수 있는 객체
    // 테스트용 추후 DB와 연동해야함
//    메모리 컷
//    @Bean
//    public InMemoryUserDetailsManager createUser() {
//        // 유저를 생성할때 유저 디테일을 사용한다.
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("jun1")
//                .password("jun")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user,admin);
//    }

    // 스프링 시큐리티의 암호화 알고리즘
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 스프링이 제공하는 기본 인코더 bcrypt 방식을 사용한다
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    // 권한에 대한 설정 - 권한에 대한 계층 구조를 설정
    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        // admin의 권한은 유저를 상회한다.
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");
        return roleHierarchy;
    }

    public AuthenticationProvider authenticationProvider() {
        // DB연동으로 인증 처리를 수행하는 provider
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder();
        provider.setUserDetailsService(customerSecurityDetailService);
        return provider;
    }

    // 기본 필터체인은 모든 페이지를 검증
    // 첫번째 페이지를 모두 허용하고 나머지만 검증하도록 변경
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> {
            // 최초 index 페이지를 response하는 / 요청만 모든 사용자에게 허용하고
            // 나머지는 인증이 된 사용자들만 접속할 수 있도록
            request.antMatchers("/", "/test", "/write")
                    .permitAll()
                    .anyRequest()
                    .authenticated();})
                .formLogin(login ->
                        login.loginPage("/mylogin")
                                .permitAll()
                                .defaultSuccessUrl("/", true)
                                .failureUrl("/login-error")
                ).logout(logout -> logout.logoutSuccessUrl("/"))
                // 권한이 없으면 accesserrer 발동
                .exceptionHandling(exception ->
                        exception.accessDeniedPage("/accesserror")
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
