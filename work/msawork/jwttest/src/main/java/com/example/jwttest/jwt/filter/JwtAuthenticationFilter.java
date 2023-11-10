package com.example.jwttest.jwt.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.jwttest.jwt.model.CustomerUserDetail;
import com.example.jwttest.jwt.model.SampleDTO1;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    // 인증요청 (로그인 : /login) 을 하면 실행될 메소드
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 1. username, password를 추출
/*
        try {
            BufferedReader reader = request.getReader();
            String line = "";
            while((line = reader.readLine()) != null) {
                log.info(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/
        // JSON을 변경할때 사용할 mapper
        ObjectMapper mapper = new ObjectMapper();
        SampleDTO1 requestDTO = null;
        try {
            requestDTO = mapper.readValue(request.getInputStream(), SampleDTO1.class);
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

        // 2. authenticationManager.authenticate() 메소드를 호출하면서 Authentication객체 전달
        // 3. 호출 후 전달되는 객체를 출력:
        // 4. return 검증 경과로 받은 token을 리턴
//        authenticationManager.authenticate();
    }

    // 인증 성공하면 실행되는 메소드
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // 인증이 성공했으므로 토큰을 발급
        // response에 셋팅
        log.info("=================================================== 로그인 ======================================================");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authResult.getPrincipal(), null, authResult.getAuthorities());
        String tokens = JWT.create()
                .withSubject("web")
                .withClaim("username", token.getName())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000*60*24)))
                .sign(Algorithm.HMAC256("key"));
        log.info("=================================================== 로그인 ======================================================");
        log.info(tokens);
        log.info("=================================================== 로그인 성공 ======================================================");
//        response.setHeader("Authorization", "Bearer " + tokens);
        response.setHeader(HttpHeaders.AUTHORIZATION, "Bearer" + tokens);
//        successfulAuthentication(request, response, chain, authResult);
    }
}