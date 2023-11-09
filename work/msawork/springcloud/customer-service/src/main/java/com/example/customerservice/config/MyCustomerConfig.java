package com.example.customerservice.config;

import com.example.customerservice.service.security.CustomerSecurityDetailService;
import com.example.customerservice.service.security.MyAuthenticationProvider;
import com.example.customerservice.service.security.handler.CustomFailureHandler;
import com.example.customerservice.service.security.handler.CustomSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class MyCustomerConfig {

    private final CustomerSecurityDetailService customerSecurityDetailService;
    private final CustomFailureHandler customFailureHandler;
    private final CustomSuccessHandler customSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        // admin의 권한은 유저를 상회한다.
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");
        return roleHierarchy;
    }

    public AuthenticationProvider authenticationProvider() {
        return new MyAuthenticationProvider(customerSecurityDetailService, passwordEncoder());
    }

/*
    기본으로 제공해주는 프로바이더가 아닌 직접 프로바이더를 커스터마이징
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customerSecurityDetailService);
        return provider;
    }
*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests((request) -> {
            request.antMatchers("/", "/customer/create")
                    .permitAll()
                    .anyRequest()
                    .authenticated();
                }).formLogin(login -> login.loginPage("/customer/login")
                        .permitAll()
                                .successHandler(customSuccessHandler)
                                .failureHandler(customFailureHandler)
                        ).logout(logout -> logout.logoutSuccessUrl("/"))
                .exceptionHandling(exception ->
                        exception.accessDeniedPage("/accesserror")
                )
                .csrf().disable();
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
        return httpSecurity.build();
    }

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