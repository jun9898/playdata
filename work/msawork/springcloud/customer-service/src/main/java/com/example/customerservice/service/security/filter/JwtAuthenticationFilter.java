package com.example.customerservice.service.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.customerservice.model.CustomerRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    // 인증요청 (로그인 : /login) 을 하면 실행될 메소드
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        // JSON을 변경할때 사용할 mapper
        ObjectMapper mapper = new ObjectMapper();
        CustomerRequestDTO requestDTO = null;
        try {
            requestDTO = mapper.readValue(request.getInputStream(), CustomerRequestDTO.class);
            log.info(requestDTO.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            log.info("=====================================================변환된 DTO==========================================================> {}",requestDTO);
            log.info("=================================================== 로그인 요청 ======================================================");
            // 1. 인증하면서 전달한 username이 password를 이용해서 UsernamePasswordAuthenticationToken을 만들기
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(requestDTO.getUsername(),requestDTO.getPassword());
            log.info(authRequest.toString());
            Authentication authenticate = authenticationManager.authenticate(authRequest);
            return authenticate;
    }

    // 인증 성공하면 실행되는 메소드
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.info("=================================================== 로그인 ======================================================");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authResult.getPrincipal(), null, authResult.getAuthorities());
        String tokens = JWT.create()
                .withSubject("web")
                .withClaim("username", token.getName())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000*60*10)))
                .sign(Algorithm.HMAC256("key"));
        log.info("=================================================== 로그인 ======================================================");
        log.info(tokens);
        log.info("=================================================== 로그인 성공 ======================================================");
        response.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + tokens);
    }
}