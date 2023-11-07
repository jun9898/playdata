package com.example.customerservice.config;

import com.example.customerservice.service.security.CustomerSecurityDetailService;
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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyCustomerConfig {

    @Autowired
    CustomerSecurityDetailService customerSecurityDetailService;

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
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customerSecurityDetailService);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests((request) -> {
            request
                    .antMatchers("/", "/customer/create")
                    .permitAll()

                    .anyRequest()
                    .authenticated();

            }).formLogin(login -> login.loginPage("/customer/login")
                        .permitAll()
                        .defaultSuccessUrl("/", false)
                        .failureUrl("/customer/login-error")
                        ).logout(logout -> logout.logoutSuccessUrl("/"))
                .exceptionHandling(exception ->
                        exception.accessDeniedPage("/accesserror")
                )
                .csrf().disable();
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
