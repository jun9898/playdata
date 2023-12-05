package com.example.redisjwt.config;

import com.example.redisjwt.jwt.CustomJwtFilter;
import com.example.redisjwt.jwt.JwtAccessDenided403Handler;
import com.example.redisjwt.jwt.JwtAuthentication401Check;
import com.example.redisjwt.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
// 웹 보안을 활성화 하겠다는 의미
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final TokenProvider provider;
    private final JwtAuthentication401Check errorhandler1;
    private final JwtAccessDenided403Handler errorhandler2;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(CsrfConfigurer :: disable) // csrf를 disable() 설정과 동일
                .addFilterBefore(new CustomJwtFilter(provider),
                        UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exceptionHandler -> {
                    exceptionHandler.authenticationEntryPoint(errorhandler1)
                            .accessDeniedHandler(errorhandler2);
                })
                // 세션을 사용하지 않을것이므로 stateless로 설정
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request -> {
            // /api/hello에 대한 요청은 인증 없이 접근할 수 있도록 허용
            request.requestMatchers(
                            new AntPathRequestMatcher("/"),
                            new AntPathRequestMatcher("/api/hello"),
                            new AntPathRequestMatcher("/api/signin"),
                            new AntPathRequestMatcher("/api/signup")
                    )
                    .permitAll()
                    // 나머지 요청에 대해서는 인증을 받도록 처리
                    .anyRequest()
                    .authenticated();
        });
        return http.build();
    }
    // 정적 리소스에 처리된 인증 제외하기
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
