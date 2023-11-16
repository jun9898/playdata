package com.example.customerservice.config;

import com.example.customerservice.dao.CustomerRepository;
import com.example.customerservice.service.security.CustomerSecurityDetailService;
import com.example.customerservice.service.security.MyAuthenticationProvider;
import com.example.customerservice.service.security.filter.JwtAuthenticationFilter;
import com.example.customerservice.service.security.filter.TokenCheckFilter;
import com.example.customerservice.service.security.handler.CustomFailureHandler;
import com.example.customerservice.service.security.handler.CustomSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class MyCustomerConfig {


    private final CustomerRepository repository;
    private final CorsFilter corsFilter;
    private final CustomerSecurityDetailService customerSecurityDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");
        return roleHierarchy;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customerSecurityDetailService);
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
                    // 세션 사용 X
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilter(corsFilter)
                .csrf().disable()
                .formLogin().disable()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new TokenCheckFilter(authenticationManager(), customerSecurityDetailService))
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "**").permitAll()
                .antMatchers("/customer/my/api/**")
                .access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/customer/admin/api/**")
                .access("hasRole('ADMIN')")
                .anyRequest()
                .permitAll()
                .and()
                .cors()
                ;
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